package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import edu.miu.cs.badgeandmembershipcontrol.domain.Membership;
import edu.miu.cs.badgeandmembershipcontrol.repository.MembershipRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;



    @Override
    public List<Membership> getMemberMemberships(Long memberId) {
        Optional<List<Membership>> memberMemberShipOptional = membershipRepository.findMembershipByMember_Id(memberId);
        if(memberMemberShipOptional.isPresent()){
            return memberMemberShipOptional.get();
        }
        return null;
    }

    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public Membership getMemberShip(Long membershipId) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            return membershipOptional.get();
        }
        return null;
    }

    @Override
    public Membership createMemberShip(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Membership updateMembership(Long membershipId, Membership membership) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            return membershipRepository.save(membership);
        }
        return null;
    }

    @Override
    public boolean removeMembership(Long membershipId) {
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            membershipRepository.deleteById(membershipId);
            return true;
        }
        return false;
    }


}
