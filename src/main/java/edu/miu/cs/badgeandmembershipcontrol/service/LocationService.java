package edu.miu.cs.badgeandmembershipcontrol.service;

import edu.miu.cs.badgeandmembershipcontrol.domain.Badge;
import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LocationService {
    List<Location> getAllLocations();

    Location getLocation(Long locationId);

    Location createLocation(Location location);

    Location updateLocation(Long locationId, Location location);

    boolean removeLocation(Long locationId);
}
