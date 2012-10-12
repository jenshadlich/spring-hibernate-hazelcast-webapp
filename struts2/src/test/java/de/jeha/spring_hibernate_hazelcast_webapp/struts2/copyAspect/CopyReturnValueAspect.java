package de.jeha.spring_hibernate_hazelcast_webapp.struts2.copyAspect;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CopyReturnValueAspect {
    @Around("@annotation(CopyReturnValue)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();
        Object copy = BeanUtils.cloneBean(retVal);
        return copy;
    }
}