package edu.miu.cs.badgeandmembershipcontrol.repository;

import edu.miu.cs.badgeandmembershipcontrol.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
}
