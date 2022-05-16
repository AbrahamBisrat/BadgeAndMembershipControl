package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.repository.MembershipRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import edu.miu.cs.badgeandmembershipcontrol.service.PlanService;
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

    @NotNull private final MemberService memberService;

    @NotNull private final PlanService planService;

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


    // Get Member and Plan and set it to Membership then it saves it
    @Override public Membership createMemberShip(Membership membership) {
        Member member = memberService.getMember(membership.getMember().getId());
        Plan plan = planService.getPlan(membership.getPlan().getId());
        membership.setMember(member);
        membership.setPlan(plan);
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
