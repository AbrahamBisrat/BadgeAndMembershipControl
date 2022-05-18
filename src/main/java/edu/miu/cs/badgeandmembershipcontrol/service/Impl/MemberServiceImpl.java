package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.*;
import edu.miu.cs.badgeandmembershipcontrol.repository.MemberRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @NotNull private final MemberRepository memberRepository;

    @NotNull private final BadgeService badgeService;

    @NotNull private final MembershipService membershipService;

    // Resolved Circular application context form a cycle
    public MemberServiceImpl(@Lazy MembershipService membershipService, BadgeService badgeService, MemberRepository memberRepository){
        this.membershipService = membershipService;
        this.badgeService = badgeService;
        this.memberRepository = memberRepository;
    }

    @Override public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override public Member getMember(Long memberId) {
       return memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("member id invalid"));
    }

    @Override public Member createMember(Member member) {
        Optional<Member> optionalMember = memberRepository.getMemberByFirstNameAndLastName(member.getFirstName(), member.getLastName());
        if(optionalMember.isPresent())
            return null;
        Member member1 = memberRepository.save(member);
        // Creates Badge with the member ID and returns the badge
        Badge badge = badgeService.createBadge(member1);
        member1.addBadge(badge);
        return member1;
    }

    @Override public Member updateMember(Long memberId, Member member) {
        member.setId(memberId);
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if(memberOptional.isPresent())
            return memberRepository.save(member);
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

    @Override public Member deActivateMembership(Long memberId, Long membershipId) {
        membershipService.deActivateMembership(membershipId,memberId);
        return memberRepository.getById(memberId);
    }

    @Override public List<Membership> getMembershipsByMemberId(Long checkerId, Long memberId) {
        List<Membership> memberships = membershipService.getMembershipsByMemberId(memberId);
        if(memberships.isEmpty()) return null;
        System.out.println("memberships = " + memberships);
        List<Membership> checkerMembershipsWithCheckerId =
                memberships .stream().filter(each -> each.getMembershipType().equals(MembershipType.CHECKER)
                        && each.getMembershipStatus().equals("Active")).toList();
        if(checkerMembershipsWithCheckerId.isEmpty()) return memberships;
        System.out.println("checkerMembershipsWithCheckerId = " + checkerMembershipsWithCheckerId);
        return checkerMembershipsWithCheckerId;
    }

    @Override public List<Badge> getBadgesByMember(Long memberId) {
        return badgeService.getBadgesByMemberId(memberId);
    }

    @Override public Badge getActiveBadgeByMember(Long memberId) {
        return badgeService.getActiveBadgeByMemberId(memberId);
    }


}
