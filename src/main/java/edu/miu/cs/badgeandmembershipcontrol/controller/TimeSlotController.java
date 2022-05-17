package edu.miu.cs.badgeandmembershipcontrol.controller;

import edu.miu.cs.badgeandmembershipcontrol.domain.TimeSlot;
import edu.miu.cs.badgeandmembershipcontrol.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/timeslots")
public class TimeSlotController {
    private final TimeSlotService timeSlotService;

    @GetMapping()
    public ResponseEntity<?> getTimeSlots(){
        return new ResponseEntity<>(timeSlotService.getAllTimeSlots(), HttpStatus.OK);
    }

    @GetMapping(path = "/{timeslotId}")
    public ResponseEntity<?> getTimeSlot(@PathVariable String timeSlotId){
        TimeSlot timeSlot = timeSlotService.getTimeSlot(Long.parseLong(timeSlotId));
        if(timeSlot == null){
            return new ResponseEntity<>("No TimeSlot is Found for this ID!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(timeSlot, HttpStatus.OK);
    }

    @GetMapping(path = "/location/{locationId}")
    public ResponseEntity<?> getLocationTimeSlots(@PathVariable String locationId){
        List<TimeSlot> timeSlotList = timeSlotService.getLocationTimeSlots(Long.parseLong(locationId));
        return new ResponseEntity<>(timeSlotList, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> createTimeSlot(@RequestBody TimeSlot timeSlot){
        TimeSlot newTimeSlot = timeSlotService.createTimeSlot(timeSlot);
        return new ResponseEntity<>(newTimeSlot, HttpStatus.OK);
    }


    @DeleteMapping(path = "/{timeSlotId}")
    public ResponseEntity<?> removeTimeSlot(@PathVariable String timeSlotId){
        if(!timeSlotService.removeTimeSlot(Long.parseLong(timeSlotId))){
            return new ResponseEntity<String>("No TimeSlot Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
