package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {

    Optional<List<Membership>> findMembershipByMember_Id(Long memberId);

    Optional<Membership> findMembershipByIdAndMember_Id(Long membershipId, Long memberId);

    Optional<List<Membership>> findMembershipsByMember_IdAndPlan_IdAndMembershipStatus(Long memberId, Long planId, String status);

}
