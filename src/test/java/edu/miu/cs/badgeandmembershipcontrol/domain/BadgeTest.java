package edu.miu.cs.badgeandmembershipcontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    void canSetBadgeInActive() {
        Badge badge = new Badge();

        badge.setStateCode("Active");
        badge.setBadgeInActive();

        assertEquals("InActive" , badge.getStateCode());
    }
}