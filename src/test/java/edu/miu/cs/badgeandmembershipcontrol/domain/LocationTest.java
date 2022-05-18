package edu.miu.cs.badgeandmembershipcontrol.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void checkTimeIsNotWithInTimeSlot() {
        List<TimeSlot> timeSlots = new ArrayList<>();
        TimeSlot timeSlot = new TimeSlot();

        timeSlot.setStartTime(LocalDateTime.now().plusHours(1));
        timeSlot.setEndTime(LocalDateTime.now().plusHours(2));

        Location location = new Location();
        location.getTimeSlots().add(timeSlot);

        assertFalse(location.checkTimeSlot());
    }
    @Test
    void checkTimeIsWithInTimeSlot() {
        List<TimeSlot> timeSlots = new ArrayList<>();
        TimeSlot timeSlot = new TimeSlot();


        timeSlot.setStartTime(LocalDateTime.now());
        timeSlot.setEndTime(LocalDateTime.now().plusHours(2));

        Location location = new Location();
        location.getTimeSlots().add(timeSlot);

        assertTrue(location.checkTimeSlot());
    }

}