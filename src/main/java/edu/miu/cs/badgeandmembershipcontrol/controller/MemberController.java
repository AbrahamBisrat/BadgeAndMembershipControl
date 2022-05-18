package edu.miu.cs.badgeandmembershipcontrol.controller;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    @NotNull private final MemberService memberService;


    @GetMapping()
    public ResponseEntity<?> getMembers(){
        List<Member> memberList = memberService.getAllMembers();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping(path = "/{memberId}")
    public ResponseEntity<?> getMember(@PathVariable Long memberId){
        Member member = memberService.getMember(memberId);
        if(member == null){
            return new ResponseEntity<>("No Member Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }


    @GetMapping(path = "/{checkerId}/{memberId}/memberships/")
    public ResponseEntity<?> getMembershipsByMember(@PathVariable Long checkerId, @PathVariable Long memberId){
        // This should be replaced by the id from the security context once security is implemented
        List<Membership> memberships = memberService.getMembershipsByMemberId(checkerId, memberId);
        if(memberships.isEmpty()){
            return new ResponseEntity<>("No Membership Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memberships, HttpStatus.OK);
    }

    @GetMapping(path = "/{memberId}/badges")
    public ResponseEntity<?> getBadgeByMember(@PathVariable String memberId){
        List<Badge> badgeList = memberService.getBadgesByMember(Long.parseLong(memberId));
        if(badgeList.isEmpty()){
            return new ResponseEntity<>("No Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(badgeList, HttpStatus.OK);
    }

    @GetMapping(path = "/{memberId}/activeBadge")
    public ResponseEntity<?> getActiveBadge(@PathVariable String memberId){
        Badge badge = memberService.getActiveBadgeByMember(Long.parseLong(memberId));
        if(badge == null){
            return new ResponseEntity<>("No Active Badge Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(badge, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createMember(@RequestBody Member member){
        Member newMember = memberService.createMember(member);
        if( newMember == null)
            return new ResponseEntity<>("Name Already Exists", HttpStatus.OK);
        return new ResponseEntity<>(newMember, HttpStatus.OK);
    }
    
    @PutMapping(path = "/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable Long memberId, @RequestBody Member member){
        if(memberService.getMember(memberId) == null) {
            return new ResponseEntity<>("No member by the Id " + memberId + " found", HttpStatus.NOT_FOUND);
        }
        Member updatedMember = memberService.updateMember(memberId , member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @PostMapping(path = "/{memberId}/renewBadge")
    public ResponseEntity<?> renewMemberBadge(@PathVariable Long memberId){
        if(memberService.getMember(memberId) == null) {
            return new ResponseEntity<>("No member by the Id "
                    + memberId + " found", HttpStatus.NOT_FOUND);
        }
        Member member = memberService.createNewBadge(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping(path = "/invokeMembership")
    public ResponseEntity<?> invokeMembership(@PathParam("memberId") Long memberId,
                                              @PathParam("membershipId") Long membershipId){
        Member member = memberService.deActivateMembership(memberId , membershipId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable Long memberId){
        if(!memberService.removeMember(memberId)){
            return new ResponseEntity<>("No Member Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
