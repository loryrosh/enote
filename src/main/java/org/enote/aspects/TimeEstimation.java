package org.enote.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class TimeEstimation {
    private Logger logger = LoggerFactory.getLogger(TimeEstimation.class);

    @Around("execution(public * org.enote.services.impl.*.*ServiceImpl+.*(..))")
    public void estimateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        BigDecimal t1 = BigDecimal.valueOf(System.currentTimeMillis());

        try {
            joinPoint.proceed();
        } finally {
            BigDecimal t2 = BigDecimal.valueOf(System.currentTimeMillis());
            logger.info("Execution time for " + joinPoint.getSignature().getName()
                    + ": " + t2.subtract(t1));
        }
    }
}
