package edu.miu.cs.badgeandmembershipcontrol.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/api/v1/plans")
public class PlanController {

    private final PlanService planService;

    @GetMapping()
    public ResponseEntity<?> getMembers(){
        return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
    }

    @GetMapping(path = "/{planId}")
    public ResponseEntity<?> getPlan(@PathVariable String planId){
        Plan plan = planService.getPlan(Long.parseLong(planId));
        if(plan == null){
            return new ResponseEntity<>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }
    
    @GetMapping(path = "/location/{locationId}")
    public ResponseEntity<?> getLocationPlans(@PathVariable String locationId){
        List<Plan> planList = planService.getLocationPlans(Long.parseLong(locationId));
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

    @GetMapping(path = "/membershipPlan/{membershipId}")
    public ResponseEntity<?> getPlanByMembership(@PathVariable String membershipId){
        Plan plan = planService.findPlanByMemberShip(Long.parseLong(membershipId));
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> createPlan(@RequestBody Plan plan){
        Plan newPlan = planService.createPlan(plan);
        return new ResponseEntity<>(newPlan, HttpStatus.OK);
    }

    @PutMapping(path = "/{planId}")
    public ResponseEntity<?> updatePlan(@PathVariable String planId, @RequestBody Plan plan){
        Plan updatedPlan = planService.updatePlan(Long.parseLong(planId), plan);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{planId}")
    public ResponseEntity<?> removePlan(@PathVariable String planId){
        if(!planService.removePlan(Long.parseLong(planId))){
            return new ResponseEntity<String>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    @GetMapping(path = "/member/{memberId}")
    public ResponseEntity<?> getPlanByMemberId(@PathVariable String memberId){
        List<Plan> planList = planService.findPlanByMember_Id(Long.parseLong(memberId));
        if(planList == null){
            return new ResponseEntity<>("No Plan found for this member!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

}
