package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MembershipService {

    List<Membership> getMemberMemberships(Long membershipId);

    List<Membership> getAllMemberships();

    Membership getMemberShip(Long membershipId);

    Membership createMemberShip(Membership membership);

    Membership updateMembership(Long membershipId, Membership membership);

    boolean removeMembership(Long membershipId);

    // Gets the Membership by Membership Id and Member Id
    Membership getMembershipByIdAndMemberId(Long membershipId, Long memberId);

    Membership deActivateMembership(Long membershipId, Long memberId);

    Optional<List<Membership>> getMembershipsByMemberIdAndPlanId(Long memberId, Long planId, String status);

}
