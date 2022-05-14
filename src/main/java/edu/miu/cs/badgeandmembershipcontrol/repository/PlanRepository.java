package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {
}
