package edu.miu.cs.badgeandmembershipcontrol.service.Impl;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.repository.BadgeRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {

    private BadgeRepository badgeRepository;

    public BadgeServiceImpl(BadgeRepository badgeRepository){
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public Badge getBadge(Long badgeId) {
        Optional<Badge> badgeOptional = badgeRepository.findById(badgeId);
        if(badgeOptional.isPresent()){
            return badgeOptional.get();
        }
        return null;
    }

    @Override
    public List<Badge> getMemberBadges(Long memberId) {
        Optional<List<Badge>> memberBadgeOptional = badgeRepository.findBadgesByMember_Id(memberId);
        if(memberBadgeOptional.isPresent()){
            return memberBadgeOptional.get();
        }
        return null;
    }

    @Override
    public Badge createBadge(Badge badge) {
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

    @Override
    public boolean removeBadge(Long badgeId) {
        Optional<Badge> badgeOptional = badgeRepository.findById(badgeId);
        if(badgeOptional.isPresent()){
            badgeRepository.deleteById(badgeId);
            return true;
        }
        return false;
    }
}
