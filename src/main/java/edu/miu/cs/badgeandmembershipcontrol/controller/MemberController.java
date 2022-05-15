package edu.miu.cs.badgeandmembershipcontrol.controller;

import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<?> getMembers(){
        List<Member> memberList = memberService.getAllMembers();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping(path = "/{memberId}")
    public ResponseEntity<?> getMember(@PathVariable String memberId){
        Member member = memberService.getMember(Long.parseLong(memberId));

        if(member == null){
            return new ResponseEntity<String>("No Member Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createMember(@RequestBody Member member){
        Member member1 = memberService.createMember(member);
        return new ResponseEntity<Member>(member1, HttpStatus.OK);
    }

    @PutMapping(path = "/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable String memberId, @RequestBody Member member){
        Member member1 = memberService.updateMember(Long.parseLong(memberId), member);
        return new ResponseEntity<Member>(member1, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable String memberId){
        Boolean result = memberService.removeMember(Long.parseLong(memberId));
        if(!result){
            return new ResponseEntity<String>("No Member Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }
}
