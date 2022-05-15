package edu.miu.cs.badgeandmembershipcontrol.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service
public interface exceptionService {

    void save(JoinPoint jp, Throwable throwable);

}
