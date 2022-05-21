package edu.miu.cs.badgeandmembershipcontrol.controller;

import java.util.List;

import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
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

import javax.annotation.security.RolesAllowed;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plans")
public class PlanController {

    private final PlanService planService;

    @GetMapping()
    public ResponseEntity<?> getPlans(){
        return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
    }

    @GetMapping(path = "/{planId}")
    public ResponseEntity<?> getPlan(@PathVariable Long planId){
        Plan plan = planService.getPlan(planId);
        if(plan == null){
            return new ResponseEntity<>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }
    
    @GetMapping(path = "/location/{locationId}")
    public ResponseEntity<?> getLocationPlans(@PathVariable Long locationId){
        List<Plan> planList = planService.getLocationPlans(locationId);
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

    @GetMapping(path = "/{planId}/location")
    public ResponseEntity<?> getPlanLocations(@PathVariable String planId){
        List<Location> locationList = planService.getPlanLocations(Long.parseLong(planId));
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping(path = "/membershipPlan/{membershipId}")
    public ResponseEntity<?> getPlanByMembership(@PathVariable Long membershipId){
        Plan plan = planService.findPlanByMemberShip(membershipId);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

    @PostMapping()
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> createPlan(@RequestBody Plan plan){
        Plan newPlan = planService.createPlan(plan);
        if(newPlan == null)
            return new ResponseEntity<>("Already Exists", HttpStatus.OK);
        return new ResponseEntity<>(newPlan, HttpStatus.OK);
    }

    @PutMapping(path = "/{planId}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> updatePlan(@PathVariable Long planId, @RequestBody Plan plan){
        Plan updatedPlan = planService.updatePlan(planId , plan);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{planId}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> removePlan(@PathVariable Long planId){
        if(!planService.removePlan(planId)){
            return new ResponseEntity<String>("No Plan Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    @GetMapping(path = "/member/{memberId}")
    public ResponseEntity<?> getPlanByMemberId(@PathVariable Long memberId){
        List<Plan> planList = planService.findPlanByMember_Id(memberId);
        if(planList == null){
            return new ResponseEntity<>("No Plan found for this member!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(planList, HttpStatus.OK);
    }

}
