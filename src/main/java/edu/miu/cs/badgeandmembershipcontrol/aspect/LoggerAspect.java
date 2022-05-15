package edu.miu.cs.badgeandmembershipcontrol.aspect;

import edu.miu.cs.badgeandmembershipcontrol.aspect.service.LoggerService;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.exceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

    @Autowired LoggerService loggerService;

    @Autowired
    edu.miu.cs.badgeandmembershipcontrol.aspect.service.exceptionService exceptionService;

    // Intercept every directory except the aspect = That would lead to -> stackOverflow
    @Pointcut("within(edu.miu.cs.badgeandmembershipcontrol..*) && !within(edu.miu.cs.badgeandmembershipcontrol.aspect..*)")
    public void entireProjectPointCut(){}

    @Around("entireProjectPointCut()")
    public void methodLogger(ProceedingJoinPoint pjp) throws Throwable{
        pjp.proceed();
        loggerService.add(pjp);
    }

    @AfterThrowing(value = "entireProjectPointCut()", throwing = "up")
    public void errorLog(JoinPoint jp, Throwable up){
        exceptionService.save(jp, up);
    }

}
