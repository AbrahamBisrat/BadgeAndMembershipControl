package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import edu.miu.cs.badgeandmembershipcontrol.repository.PlanRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.PlanService;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository){
        this.planRepository = planRepository;
    }
}
