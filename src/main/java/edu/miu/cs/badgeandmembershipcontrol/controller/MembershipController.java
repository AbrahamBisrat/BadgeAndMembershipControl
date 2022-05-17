package edu.miu.cs.badgeandmembershipcontrol.controller;


import edu.miu.cs.badgeandmembershipcontrol.domain.LocationType;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<?> getMemberShip(@PathVariable Long memberShipId){
        Membership memberShip = membershipService.getMemberShip(memberShipId);
        if(memberShip == null){
            return new ResponseEntity<>("No Membership Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memberShip, HttpStatus.OK);
    }

    @GetMapping(path = "/membership/{membershipId}") // This will have to be flipped - to comply with the reqs
    public ResponseEntity<?> getMemberMemberships(@PathVariable String membershipId){
        List<Membership> memberShipList = membershipService
                .getMemberMemberships(Long.parseLong(membershipId));
        return new ResponseEntity<>(memberShipList, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> createMembership(@RequestBody Membership membership){
        Membership newMembership = membershipService.createMemberShip(membership);
        if(newMembership == null){
            return new ResponseEntity<String>("Could Not Create MemberShip!", HttpStatus.CONFLICT);
        }
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


    @GetMapping(path = "/checkAccess")
    public ResponseEntity<?> checkMemberDoorAccess(@PathParam("memberId") Long memberId,
                                                   @PathParam("locationId") Long locationId,
                                                   @PathParam("locationType") LocationType locationType){
        boolean accessResponse = membershipService.checkDoorAccess(memberId, locationId,locationType);
        if(accessResponse){
            return new ResponseEntity<>("Granted", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Not Allowed", HttpStatus.OK);
    }

}
