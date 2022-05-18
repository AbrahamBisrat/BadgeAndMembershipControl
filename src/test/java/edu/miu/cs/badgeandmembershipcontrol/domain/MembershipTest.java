package edu.miu.cs.badgeandmembershipcontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {

    @Test
    void deActivateMembership() {
        Membership membership = new Membership();
         membership.setMembershipStatus("Active");
         membership.deActivateMembership();

         assertEquals("InActive" ,membership.getMembershipStatus() );
    }
}