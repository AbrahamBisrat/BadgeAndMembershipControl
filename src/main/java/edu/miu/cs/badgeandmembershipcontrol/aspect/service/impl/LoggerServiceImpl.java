package edu.miu.cs.badgeandmembershipcontrol.aspect.service.impl;

import edu.miu.cs.badgeandmembershipcontrol.aspect.domain.Logger;
import edu.miu.cs.badgeandmembershipcontrol.aspect.repo.LoggerRepo;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {

    private final LoggerRepo loggerRepo;

    public LoggerServiceImpl(LoggerRepo loggerRepo) {
        this.loggerRepo = loggerRepo;
    }

    @Override public void add(ProceedingJoinPoint pjp) {
        loggerRepo.save(
            Logger.builder()
                    .date(LocalDate.now())
                    .time(LocalTime.now())
                    .principle("operation") // This should be replaced with subject after the security is implemented
                    .operation(pjp.getSignature().getName())
                    .build());
    }

    @Override public List<Logger> findAll() {
        return loggerRepo.findAll();
    }

}
