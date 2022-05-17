package edu.miu.cs.badgeandmembershipcontrol.controller;


import edu.miu.cs.badgeandmembershipcontrol.aspect.annotations.ExcutionTime;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.service.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/badges")
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping()
    @ExcutionTime
    public ResponseEntity<?> getBadges() {
        return new ResponseEntity<>(badgeService.getAllBadges(), HttpStatus.OK);
    }

    @GetMapping(path = "/{badgeId}")
    public ResponseEntity<?> getBadge(@PathVariable Long badgeId){
        Badge badge = badgeService.getBadge(badgeId);
        if(badge == null){
            return new ResponseEntity<>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(badge, HttpStatus.OK);
    }

    @GetMapping(path = "/member/{memberId}")
    public ResponseEntity<?> getMemberBadges(@PathVariable Long memberId){
        List<Badge> badgeList = badgeService.getMemberBadges(memberId);
        return new ResponseEntity<>(badgeList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createBadge(@RequestBody Badge badge){
        Badge newBadge = badgeService.createBadge(badge);
        return new ResponseEntity<>(newBadge, HttpStatus.OK);
    }

    @PutMapping(path = "/{badgeId}")
    public ResponseEntity<?> updateBadge(@PathVariable Long badgeId, @RequestBody Badge badge){
        Badge updatedBadge = badgeService.updateBadge(badgeId ,badge);
        if(updatedBadge == null){
            return new ResponseEntity<>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBadge, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{badgeId}")
    public ResponseEntity<?> deleteBadge(@PathVariable Long badgeId){
        if(!badgeService.removeBadge(badgeId)){
            return new ResponseEntity<>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
