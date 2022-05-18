package edu.miu.cs.badgeandmembershipcontrol.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void canAddBadge() {
        List<Badge> badge = new ArrayList<>();
        Badge b1 = new Badge();
        b1.setId(1L);
        b1.setExpiryDate(LocalDate.now());
        b1.setCreatedOn(LocalDateTime.now());
        b1.setModifiedOn(LocalDateTime.now());

        badge.add(b1);

        Member member = new Member();
        member.addBadge(b1);
//        member.setBadges(badge);

        assertNotNull(member);
        assertEquals(badge, member.getBadges());
    }

}