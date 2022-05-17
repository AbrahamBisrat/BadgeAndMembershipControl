package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Plan;
import edu.miu.cs.badgeandmembershipcontrol.domain.TimeSlot;
import edu.miu.cs.badgeandmembershipcontrol.repository.TimeSlotRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {

   @NotNull private final TimeSlotRepository timeSlotRepository;

   @Override
   public List<TimeSlot> getAllTimeSlots() {
      return timeSlotRepository.findAll();
   }

   @Override
   public TimeSlot getTimeSlot(Long timeSlotId) {
      Optional<TimeSlot> timeSlotOptional = timeSlotRepository.findById(timeSlotId);
      return timeSlotOptional.orElse(null);
   }

   @Override
   public List<TimeSlot> getLocationTimeSlots(Long locationId) {
      Optional<List<TimeSlot>> locationTimeSlotsOptional = timeSlotRepository.getLocationTimeSlots(locationId);
      return locationTimeSlotsOptional.orElse(null);
   }

   @Override
   public TimeSlot createTimeSlot(TimeSlot timeSlot) {
      return timeSlotRepository.save(timeSlot);
   }

   @Override
   public boolean removeTimeSlot(Long timeSlotId) {
      Optional<TimeSlot> timeSlotOptional = timeSlotRepository.findById(timeSlotId);
      if(timeSlotOptional.isPresent()){
         timeSlotRepository.deleteById(timeSlotId);
         return true;
      }
      return false;
   }
}
