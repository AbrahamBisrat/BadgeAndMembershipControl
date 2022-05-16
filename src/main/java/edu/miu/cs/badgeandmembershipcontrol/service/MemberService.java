package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<Member> getAllMembers();

    Member getMember(Long memberId);

    Member createMember(Member member);

    Member updateMember(Long memberId, Member member);

    boolean removeMember(Long memberId);

    Member createNewBadge(Long memberId);

    Membership addMembership(Long memberId, Long planId, Membership membership);

}
