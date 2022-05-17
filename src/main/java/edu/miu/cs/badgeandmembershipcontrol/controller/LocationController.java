package edu.miu.cs.badgeandmembershipcontrol.controller;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.LocationType;
import edu.miu.cs.badgeandmembershipcontrol.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static edu.miu.cs.badgeandmembershipcontrol.domain.ResponseTypeMapper.ResponseType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {

    @NotNull private final LocationService locationService;

    @GetMapping
    public ResponseEntity<?>getLocations(){
        return new ResponseEntity<>(ResponseType(locationService.getAllLocations()), HttpStatus.OK);
    }

    @GetMapping(path = "/{locationId}")
    public ResponseEntity<?> getLocation(@PathVariable Long locationId){
        Location location = locationService.getLocation(locationId);

        if(location == null){
            return new ResponseEntity<>("No Location Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping(path = "/type/{locationType}")
    public ResponseEntity<?> getLocationByLocationType(@PathVariable LocationType locationType){
        List<Location> locationList = locationService.getLocationsByLocationType(locationType);

        if(locationList == null){
            return new ResponseEntity<String>("No Locations Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ResponseType(locationList), HttpStatus.OK);
    }
//find the right name for message
    @PostMapping
    public ResponseEntity<?> createLocation( @RequestBody Location location){
        Location newLocation = locationService.createLocation(location);
        System.out.println("newLocation = " + newLocation);
        if(newLocation == null)
            return new ResponseEntity<>("Already Exists", HttpStatus.OK);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{locationId}")
    public ResponseEntity<?> updateLocation(@PathVariable Long locationId, @RequestBody Location location){
        Location updatedLocation = locationService.updateLocation(locationId , location);
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{locationId}")
    public ResponseEntity<?> deleteLocation(@PathVariable Long locationId) {
        if (!locationService.removeLocation(locationId)) {
            return new ResponseEntity<>("No Location Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

}
