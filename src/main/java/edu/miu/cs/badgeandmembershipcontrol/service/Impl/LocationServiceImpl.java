package edu.miu.cs.badgeandmembershipcontrol.service.Impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import edu.miu.cs.badgeandmembershipcontrol.domain.LocationType;
import edu.miu.cs.badgeandmembershipcontrol.repository.LocationRepository;
import edu.miu.cs.badgeandmembershipcontrol.service.LocationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    @NotNull private final LocationRepository locationRepository;

    @Override public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override public Location getLocation(Long locationId) {
        Optional<Location> locationOptional = locationRepository.findById(locationId);
        return locationOptional.orElse(null);
    }

    @Override public Location createLocation(Location location) {
        // if the location already exists do not take it!
        Optional<Location> optionalLocation = locationRepository.findLocationByName(location.getName());
        if(optionalLocation.isEmpty())
            return locationRepository.save(location);
        return null;
    }

    @Override public Location updateLocation(Long locationId, Location location) {
        Optional<Location> locationOptional = locationRepository.findById(locationId);
        if(locationOptional.isPresent()){
            return locationRepository.save(location);
        }
        return null;
    }

    @Override public List<Location> getLocationsByLocationType(LocationType locationType) {
        Optional<List<Location>> optionalLocationList = locationRepository.findLocationByLocationType(locationType);
        return optionalLocationList.orElse(null);
    }

    @Override public boolean removeLocation(Long locationId) {
        Optional<Location> locationOptional =locationRepository.findById(locationId);
        if(locationOptional.isPresent()){
            locationRepository.deleteById(locationId);
            return true;
        }
        return false;
    }

}

