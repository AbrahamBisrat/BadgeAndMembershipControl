package edu.miu.cs.badgeandmembershipcontrol.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(edu.miu.cs.badgeandmembershipcontrol.aspect.annotations.ExcutionTime)")
    public void timeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalTime beforeExecution = LocalTime.now();
        proceedingJoinPoint.proceed();
        LocalTime afterExecution = LocalTime.now();

        String message =
                "|||**  Execution time details  **|||"
                + "\n" + beforeExecution
                + "\n" + afterExecution
                + "\n" + "Time elapsed while executing -->> "
                + proceedingJoinPoint.getSignature().getName()
                + " <<--  : "
                + Duration.between(beforeExecution, afterExecution).toMillis()
                + "ms";

        System.out.println(message);
    }

}
