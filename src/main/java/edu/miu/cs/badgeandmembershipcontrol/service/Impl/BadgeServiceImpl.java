package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.repository.BadgeRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;

    @Override public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override public Badge getBadge(Long badgeId) {
        Optional<Badge> badgeOptional = badgeRepository.findById(badgeId);
        return badgeOptional.orElse(null);
    }

    @Override public List<Badge> getMemberBadges(Long memberId) {
        Optional<List<Badge>> memberBadgeOptional = badgeRepository.findBadgesByMemberId(memberId);
        return memberBadgeOptional.orElse(null);
    }

    @Override
    public Badge getActiveBadgeByMemberId(Long memberId) {
        return badgeRepository.findBadgeByMemberIdAndStateCode(memberId,"Active");
    }

    @Override
    public Badge deactivateBadge(Long memberId) {
        Badge oldBadge = getActiveBadgeByMemberId(memberId);
        oldBadge.setBadgeInActive();
        return badgeRepository.save(oldBadge);
    }

    @Override public Badge createBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge createBadge(Member member) {
        Badge badge = new Badge();
        badge.setCreatedOn(LocalDateTime.now());
        badge.setExpiryDate(LocalDate.from(LocalDateTime.now().plusYears(1)));
        badge.setMember(member);
        return badgeRepository.save(badge);
    }

    @Override
    public Badge updateBadge(Long badgeId, Badge badge) {
        Optional<Badge> badgeOptional = badgeRepository.findById(badgeId);
        if(badgeOptional.isPresent()){
            return badgeRepository.save(badge);
        }
        return null;
    }

    @Override public boolean removeBadge(Long badgeId) {
        Optional<Badge> badgeOptional = badgeRepository.findById(badgeId);
        if(badgeOptional.isPresent()){
            badgeRepository.deleteById(badgeId);
            return true;
        }
        return false;
    }

}
