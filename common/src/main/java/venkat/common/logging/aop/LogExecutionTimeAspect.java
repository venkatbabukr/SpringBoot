package venkat.common.logging.aop;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogExecutionTimeAspect {

	@Around("@annotation(venkat.common.logging.aop.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Instant startTime = Instant.now();
		Object proceed = joinPoint.proceed();
		Instant endTime = Instant.now();
		Duration executionDuration = Duration.between(startTime, endTime);
		log.debug("{} execution time {} ms", joinPoint.getSignature(), executionDuration.toMillis());
		return proceed;
	}

}
