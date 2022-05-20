package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findMemberByIdAndBadges_StateCode(Long memberId, String status);

    Optional<Member>  getMemberByFirstNameAndLastName(String firstName ,String lastName);

}
