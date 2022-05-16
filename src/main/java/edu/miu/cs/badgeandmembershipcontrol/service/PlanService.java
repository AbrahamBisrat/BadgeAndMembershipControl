package edu.miu.cs.badgeandmembershipcontrol.service;


import java.util.List;

import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;


public interface PlanService {

    List<Plan> getAllPlans();

    Plan getPlan(Long planId);

    List<Plan> getLocationPlans(Long locationId);

    Plan createPlan(Plan plan);

    Plan updatePlan(Long planId, Plan plan);

    List<Membership> findPlanByMemberShip(Long membershipId);

    boolean removePlan(Long planId);
}

