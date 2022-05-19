package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BadgeRepository extends JpaRepository<Badge,Long> {

    Optional<List<Badge>> findBadgesByMemberIdOrderByStateCode(Long memberId);

    Badge findBadgeByMemberIdAndStateCode(Long memberId,String stateCode);

}
