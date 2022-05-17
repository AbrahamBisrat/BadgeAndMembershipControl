package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
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

    Member deActivateMembership(Long memberId, Long membershipId);

    List<Membership> getMembershipsByMemberId(Long memberId);

    List<Badge> getBadgesByMember(Long memberId);
    Badge getActiveBadgeByMember(Long memberId);



}
