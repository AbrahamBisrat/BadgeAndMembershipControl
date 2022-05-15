package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    Member getMember(Long memberId);

    Member createMember(Member member);

    Member updateMember(Long memberId, Member member);

    boolean removeMember(Long memberId);
}
