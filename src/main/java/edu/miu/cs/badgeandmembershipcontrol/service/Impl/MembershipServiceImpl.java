package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import edu.miu.cs.badgeandmembershipcontrol.repository.MemberRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService {

    private MemberRepository memberRepository;

    public MembershipServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
}
