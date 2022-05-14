package edu.miu.cs.badgeandmembershipcontrol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Plan extends JpaRepository<Plan,Long> {
}
