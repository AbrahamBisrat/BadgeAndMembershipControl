package edu.miu.cs.badgeandmembershipcontrol.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

//    @Autowired
//    LoggerService loggerService;
//
//    @Autowired
//    com.waaAssig.Assignment.aspect.logger.service.exceptionService exceptionService;
//
//    @Pointcut("within(com.waaAssig.Assignment..*) && !within(com.waaAssig.Assignment.aspect..*)")
//    public void entireProjectPointCut(){}
//
//    @Around("entireProjectPointCut()")
//    public void methodLogger(ProceedingJoinPoint pjp) throws Throwable{
//        pjp.proceed();
//        loggerService.add(pjp);
//    }
//
//    @AfterThrowing(value = "entireProjectPointCut()", throwing = "up")
//    public void errorLog(JoinPoint jp, Throwable up){
//        exceptionService.save(jp, up);
//    }

}
