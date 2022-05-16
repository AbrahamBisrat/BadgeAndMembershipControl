package edu.miu.cs.badgeandmembershipcontrol.controller;


import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping()
    public ResponseEntity<?> getMemberships() {
        return new ResponseEntity<>(membershipService.getAllMemberships(), HttpStatus.OK);
    }

    @GetMapping(path = "/{memberShipId}")
    public ResponseEntity<?> getMemberShip(@PathVariable String memberShipId){
        Membership memberShip = membershipService.getMemberShip(Long.parseLong(memberShipId));

        if(memberShip == null){
            return new ResponseEntity<>("No Membership Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memberShip, HttpStatus.OK);
    }

    @GetMapping(path = "/membership/{membershipId}")
    public ResponseEntity<?> getMemberMemberships(@PathVariable String membershipId){
        List<Membership> memberShipList = membershipService
                .getMemberMemberships(Long.parseLong(membershipId));
        return new ResponseEntity<>(memberShipList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createMembership(@RequestBody Membership membership){
        Membership newMembership = membershipService.createMemberShip(membership);
        return new ResponseEntity<>(newMembership, HttpStatus.OK);
    }

    @PutMapping(path = "/{membershipId}")
    public ResponseEntity<?> updateMembership(@PathVariable String membershipId,
                                              @RequestBody Membership membership){
        Membership updatedMembership = membershipService
                .updateMembership(Long.parseLong(membershipId),membership);

        if(updatedMembership == null){
            return new ResponseEntity<String>("No MemberShip Found by the Id "
                    + membershipId + " found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMembership, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{membershipId}")
    public ResponseEntity<?> deleteMemberShip(@PathVariable String membershipId){
        if(!membershipService.removeMembership(Long.parseLong(membershipId))){
            return new ResponseEntity<String>("No MemberShip Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
