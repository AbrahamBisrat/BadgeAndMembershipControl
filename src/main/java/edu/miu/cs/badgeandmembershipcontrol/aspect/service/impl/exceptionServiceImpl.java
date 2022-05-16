package edu.miu.cs.badgeandmembershipcontrol.aspect.service.impl;

import edu.miu.cs.badgeandmembershipcontrol.aspect.domain.exception;
import edu.miu.cs.badgeandmembershipcontrol.aspect.repo.exceptionRepo;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.exceptionService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class exceptionServiceImpl implements exceptionService {

    private final exceptionRepo exRepo;

    public exceptionServiceImpl(exceptionRepo exRepo) {
        this.exRepo = exRepo;
    }

    @Override public void save( JoinPoint jp, Throwable throwable ){
        exRepo.save(
                exception.builder()
                        .date(LocalDate.now())
                        .time(LocalTime.now())
                        .operation(jp.getSignature().getName())
                        .exceptionType(throwable.getClass().getName())
                        .exceptionMessage(throwable.getMessage())
                        .build());
    }

}
