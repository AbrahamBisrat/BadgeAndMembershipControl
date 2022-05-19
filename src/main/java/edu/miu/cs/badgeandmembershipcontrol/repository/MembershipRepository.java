package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.LocationType;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {

    Optional<List<Membership>> findMembershipByMember_Id(Long memberId);

    Optional<Membership> findMembershipByIdAndMember_Id(Long membershipId, Long memberId);

    Optional<List<Membership>> findMembershipsByMember_IdAndPlan_IdAndMembershipStatus(Long memberId, Long planId, String status);

//    Optional<Membership> findMembershipByPlan_Location_IdAndMember_IdAndMembershipStatusAndPlan_Location_LocationType(Long locationId, Long memberId, String status, LocationType locationType);

//    Optional<Membership> findMembershipByPlan_Location_IdAndIn

    Optional<List<Membership>> findMembershipsByMember_Id(Long memberId);

    // return membersMembership to which has the same memberId.
    Optional<Membership> findMembershipByMember_IdAndMembershipTypeAndPlan_Id(Long memberId, MembershipType membershipType, Long planId);

    Optional<Membership> findMembershipByMember_IdAndPlan_Id(Long MemberId, Long planId);

}
