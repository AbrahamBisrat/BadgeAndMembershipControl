package edu.miu.cs.badgeandmembershipcontrol.service.Impl;


import com.sun.istack.NotNull;

import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.repository.PlanRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.PlanService;

import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

 	@NotNull private final PlanRepository planRepository;

	@Override public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}

	@Override public Plan getPlan(Long planId) {
		Optional<Plan> planOptional = planRepository.findById(planId);
		return planOptional.orElse(null);
	}

	@Override public List<Plan> getLocationPlans(Long locationId) {
		Optional<List<Plan>> membershipPlansOptional = planRepository.findPlansByLocation_Id(locationId);
		return membershipPlansOptional.orElse(null);
	}

	@Override public Plan createPlan(Plan plan) {
		return planRepository.save(plan);
	}

	@Override public Plan updatePlan(Long planId, Plan plan) {
		Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isPresent()){
            return planRepository.save(plan);
        }
        return null;
	}


	@Override public boolean removePlan(Long planId) {

		Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isPresent()){
            planRepository.deleteById(planId);
            return true;
        }
        return false;
	}

}
