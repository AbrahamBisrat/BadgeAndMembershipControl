package edu.miu.cs.badgeandmembershipcontrol.aspect.repo;

import edu.miu.cs.badgeandmembershipcontrol.aspect.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {

    List<Logger> findAll();

}
