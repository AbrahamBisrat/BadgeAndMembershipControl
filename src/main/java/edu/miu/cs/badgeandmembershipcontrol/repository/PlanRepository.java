package edu.miu.cs.badgeandmembershipcontrol.repository;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {

	@Query("select m.plan from Membership m where m.id=? 1 ")
	Optional<List<Membership>> findPlanByMembership(long memberShipId);

	Optional<List<Plan>> findPlansByLocation_Id(Long locationId);
}
