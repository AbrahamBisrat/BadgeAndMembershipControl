package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.domain.TimeSlot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimeSlotService {
    List<TimeSlot> getAllTimeSlots();

    TimeSlot getTimeSlot(Long timeSlotId);

    List<TimeSlot> getLocationTimeSlots(Long locationId);

    TimeSlot createTimeSlot(TimeSlot timeSlot);

    //TimeSlot updateLocationTimeSlot(Long locationId, TimeSlot timeSlot);

    boolean removeTimeSlot(Long transactionId);
}
