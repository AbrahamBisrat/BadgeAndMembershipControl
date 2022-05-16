package edu.miu.cs.badgeandmembershipcontrol.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.service.PlanService;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {
    private PlanService planService;

    public PlanController(PlanService planService){
        this.planService = planService;
    }

    @GetMapping()
    public ResponseEntity<?> getMembers(){
        List<Plan> planList = planService.getAllPlans();
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

    @GetMapping(path = "/{planId}")
    public ResponseEntity<?> getPlan(@PathVariable String planId){
        Plan plan = planService.getPlan(Long.parseLong(planId));
        if(plan == null){
            return new ResponseEntity<String>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Plan>(plan, HttpStatus.OK);
    }
    
    @GetMapping(path = "/location/{locationId}")
    public ResponseEntity<?> getLocationPlans(@PathVariable String locationId){
        List<Plan> planList = planService.getLocationPlans(Long.parseLong(locationId));
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createPlan(@RequestBody Plan plan){
        Plan plan1 = planService.createPlan(plan);
        return new ResponseEntity<Plan>(plan1, HttpStatus.OK);
    }

    @PutMapping(path = "/{planId}")
    public ResponseEntity<?> updatePlan(@PathVariable String planId, @RequestBody Plan plan){
        Plan plan1 = planService.updatePlan(Long.parseLong(planId), plan);
        return new ResponseEntity<Plan>(plan1, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{planId}")
    public ResponseEntity<?> removePlan(@PathVariable String planId){
        Boolean result = planService.removePlan(Long.parseLong(planId));
        if(!result){
            return new ResponseEntity<String>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
