package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.repository.TimeSlotRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {

   @NotNull
   private final TimeSlotRepository timeSlotRepository;

}
