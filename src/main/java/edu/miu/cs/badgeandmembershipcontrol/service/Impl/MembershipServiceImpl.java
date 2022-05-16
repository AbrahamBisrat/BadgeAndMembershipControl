package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.repository.MembershipRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    @NotNull private final MembershipRepository membershipRepository;

    @Override public List<Membership> getMemberMemberships(Long memberId) {
        Optional<List<Membership>> memberMemberShipOptional = membershipRepository.findMembershipByMember_Id(memberId);
        return memberMemberShipOptional.orElse(null);
    }

    @Override public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override public Membership getMemberShip(Long membershipId) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        return membershipOptional.orElse(null);
    }

    @Override public Membership createMemberShip(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override public Membership updateMembership(Long membershipId, Membership membership) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            return membershipRepository.save(membership);
        }
        return null;
    }

    @Override public boolean removeMembership(Long membershipId) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            membershipRepository.deleteById(membershipId);
            return true;
        }
        return false;
    }

}
