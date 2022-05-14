package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import edu.miu.cs.badgeandmembershipcontrol.repository.TimeSlotRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.TimeSlotService;

public class TimeSlotServiceImpl implements TimeSlotService {

    private TimeSlotRepository timeSlotRepository;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository){
        this.timeSlotRepository = timeSlotRepository;
    }
}
