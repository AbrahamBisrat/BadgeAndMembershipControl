package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
