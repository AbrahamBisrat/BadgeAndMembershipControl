package edu.miu.cs.badgeandmembershipcontrol.controller;


import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/badges")
public class BadgeController {

    private BadgeService badgeService;

    BadgeController(BadgeService badgeService){
        this.badgeService = badgeService;
    }

    @GetMapping()
    public ResponseEntity<?> getBadges() {
        List<Badge> badgeList = badgeService.getAllBadges();
        return new ResponseEntity<>(badgeList, HttpStatus.OK);
    }

    @GetMapping(path = "/{badgeId}")
    public ResponseEntity<?> getBadge(@PathVariable String badgeId){
        Badge badge = badgeService.getBadge(Long.parseLong(badgeId));

        if(badge == null){
            return new ResponseEntity<String>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Badge>(badge, HttpStatus.OK);
    }

    @GetMapping(path = "/member/{memberId}")
    public ResponseEntity<?> getMemberBadges(@PathVariable String memberId){
        List<Badge> badgeList = badgeService.getMemberBadges(Long.parseLong(memberId));
        return new ResponseEntity<>(badgeList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createBadge(@RequestBody Badge badge){

        Badge badge1 = badgeService.createBadge(badge);
        return new ResponseEntity<Badge>(badge1, HttpStatus.OK);
    }

    @PutMapping(path = "/{badgeId}")
    public ResponseEntity<?> updateBadge(@PathVariable String badgeId, @RequestBody Badge badge){
        Badge badge1 = badgeService.updateBadge(Long.parseLong(badgeId),badge);
        if(badge1 == null){
            return new ResponseEntity<String>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Badge>(badge1, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{badgeId}")
    public ResponseEntity<?> deleteBadge(@PathVariable String badgeId){
        Boolean result = badgeService.removeBadge(Long.parseLong(badgeId));
        if(!result){
            return new ResponseEntity<String>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
