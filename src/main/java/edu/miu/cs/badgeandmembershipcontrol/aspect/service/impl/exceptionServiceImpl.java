package edu.miu.cs.badgeandmembershipcontrol.aspect.service.impl;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.aspect.domain.exception;
import edu.miu.cs.badgeandmembershipcontrol.aspect.repo.exceptionRepo;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.exceptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class exceptionServiceImpl implements exceptionService {

    @NotNull private final exceptionRepo exRepo;

    @Override public void save( JoinPoint jp, Throwable throwable ){
        exRepo.save(
                exception.builder()
                        .date(LocalDate.now())
                        .time(LocalTime.now())
                        .operation(jp.getSignature().getName())
                        .exceptionType(throwable.getClass().getName())
                        .exceptionMessage(throwable.getMessage())//.substring(0, 248))
                        .build());
    }

}
