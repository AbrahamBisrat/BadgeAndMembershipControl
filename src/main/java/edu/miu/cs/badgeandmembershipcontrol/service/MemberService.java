package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;

import java.util.List;

public interface MemberService {

    abstract List<Member> getAllMembers();

    abstract Member getMember(Long memberId);

    abstract Member createMember(Member member);

    abstract Member updateMember(Long memberId, Member member);

    abstract boolean removeMember(Long memberId);
}
