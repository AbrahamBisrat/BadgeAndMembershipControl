package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge,Long> {
}
