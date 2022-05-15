package edu.miu.cs.badgeandmembershipcontrol.controller;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.Member;
import edu.miu.cs.badgeandmembershipcontrol.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private LocationService locationService;


    LocationController(LocationService locationService){
        this.locationService= locationService;
    }

    @GetMapping
    public ResponseEntity<?>getLocations(){
        List<Location> locationList = locationService.getAllLocations();
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping(path = "/{locationId}")
    public ResponseEntity<?> getLocation(@PathVariable String locationId){
        Location location = locationService.getLocation(Long.parseLong(locationId));

        if(location == null){
            return new ResponseEntity<String>("No Location Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createLocation(@RequestBody Location location){
        Location location1 = locationService.createLocation(location);
        return new ResponseEntity<Location>(location1, HttpStatus.OK);
    }
    @PutMapping(path = "/{locationId}")
    public ResponseEntity<?> updateLocation(@PathVariable String locationId, @RequestBody Location location){
        Location location1 = locationService.updateLocation(Long.parseLong(locationId), location);
        return new ResponseEntity<Location>(location1, HttpStatus.OK);
    }
    @DeleteMapping(path = "/{locationId}")
    public ResponseEntity<?> deleteLocation(@PathVariable String locationId){
        Boolean result = locationService.removeLocation(Long.parseLong(locationId));
        if(!result){
            return new ResponseEntity<String>("No Location Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }
}
