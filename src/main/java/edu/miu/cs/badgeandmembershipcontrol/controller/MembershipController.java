package edu.miu.cs.badgeandmembershipcontrol.controller;


import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping()
    public ResponseEntity<?> getMemberships() {
        List<Membership> badgeList = membershipService.getAllMemberships();
        return new ResponseEntity<>(badgeList, HttpStatus.OK);
    }

    @GetMapping(path = "/{memberShipId}")
    public ResponseEntity<?> getMemberShip(@PathVariable String memberShipId){
        Membership memberShip = membershipService.getMemberShip(Long.parseLong(memberShipId));

        if(memberShip == null){
            return new ResponseEntity<String>("No Membership Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Membership>(memberShip, HttpStatus.OK);
    }

    @GetMapping(path = "/membership/{membershipId}")
    public ResponseEntity<?> getMemberMemberships(@PathVariable String membershipId){
        List<Membership> memberShipList = membershipService.getMemberMemberships(Long.parseLong(membershipId));
        return new ResponseEntity<>(memberShipList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createMembership(@RequestBody Membership membership){

        Membership memberShip = membershipService.createMemberShip(membership);
        return new ResponseEntity<Membership>(memberShip, HttpStatus.OK);
    }

    @PutMapping(path = "/{membershipId}")
    public ResponseEntity<?> updateMembership(@PathVariable String membershipId, @RequestBody Membership membership){
        Membership mship = membershipService.updateMembership(Long.parseLong(membershipId),membership);
        if(mship == null){
            return new ResponseEntity<String>("No MemberShip Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Membership>(mship, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{membershipId}")
    public ResponseEntity<?> deleteMemberShip(@PathVariable String membershipId){
        Boolean result = membershipService.removeMembership(Long.parseLong(membershipId));
        if(!result){
            return new ResponseEntity<String>("No MemberShip Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }


}
