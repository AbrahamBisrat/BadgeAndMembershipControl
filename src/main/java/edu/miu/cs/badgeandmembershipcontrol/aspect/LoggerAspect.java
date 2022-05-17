package edu.miu.cs.badgeandmembershipcontrol.aspect;

import com.sun.istack.NotNull;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.LoggerService;
import edu.miu.cs.badgeandmembershipcontrol.aspect.service.exceptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {

    @NotNull private final LoggerService loggerService;

    @NotNull private final exceptionService exceptionService;

    // Intercept every directory except the aspect = That would lead to -> stackOverflow
    @Pointcut("within(edu.miu.cs.badgeandmembershipcontrol..*) && !within(edu.miu.cs.badgeandmembershipcontrol.aspect..*)")
    public void entireProjectPointCut(){}

    @Around("entireProjectPointCut()")
    public Object methodLogger(ProceedingJoinPoint pjp) throws Throwable{
        Object retVal = pjp.proceed();
        loggerService.add(pjp);

        return retVal;
    }

    @AfterThrowing(value = "entireProjectPointCut()", throwing = "up")
    public void errorLog(JoinPoint jp, Throwable up){
        exceptionService.save(jp, up);
    }

}