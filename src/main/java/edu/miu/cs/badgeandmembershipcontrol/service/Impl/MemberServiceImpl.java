package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.repository.MemberRepository;
import edu.miu.cs.badgeandmembershipcontrol.repository.MembershipRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import edu.miu.cs.badgeandmembershipcontrol.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @NotNull private final PlanService planService;
    @NotNull private final BadgeService badgeService;
    @NotNull private final MemberRepository memberRepository;
    @NotNull private final MembershipRepository membershipRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override public Member getMember(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        return memberOptional.orElse(null);
    }

    @Override public Member createMember(Member member) {
        Member member1 = memberRepository.save(member);
        // Creates Badge with the member ID and returns the badge
        Badge badge = badgeService.createBadge(member1);
        member1.addBadge(badge);
        return member1;
    }

    @Override public Member updateMember(Long memberId, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            return memberRepository.save(member);
        }
        return null;
    }

    @Override public boolean removeMember(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            memberRepository.deleteById(memberId);
            return true;
        }
        return false;
    }

    @Override public Member createNewBadge(Long memberId) {
        Member member = getMember(memberId);
        if(member == null ){
            return null;
        }
        badgeService.deactivateBadge(memberId);
        badgeService.createBadge(member);
        return member;
    }

    @Override public Membership addMembership(
            Long memberId, Long planId, Membership membership) {
        Plan plan = planService.getPlan(planId);
        Member member = memberRepository.findById(memberId).orElse(null);
        if(member == null || plan == null){
            System.out.println("Bad request, The id belong to nothing");
            return null;
        }
        membership.setMember(member);
        membership.setPlan(plan);
        membershipRepository.save(membership);
        System.out.println("membership = " + membership);
        return membership;
    }

}
