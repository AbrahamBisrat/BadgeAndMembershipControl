package edu.miu.cs.badgeandmembershipcontrol.aspect.service;

import edu.miu.cs.badgeandmembershipcontrol.aspect.domain.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoggerService {

    void add(ProceedingJoinPoint pjp);

    List<Logger> findAll();

}
