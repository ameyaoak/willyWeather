package com.weather.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * Logs all entry points and bean creations
	 * @param joinPoint
	 */
	@Before("execution(* com.weather.*.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		log.info("Bean created for : " + joinPoint.getTarget().getClass().getSimpleName());
		log.info("Calling Method : " + joinPoint.getSignature().toShortString());
	}

	/**
	 * Logs method completions
	 * @param joinPoint
	 */
	@After("execution(* com.weather.*.*(..))")
	public void logFieldData(JoinPoint joinPoint) { 
		log.info("Exiting Method : " + joinPoint.getSignature().toShortString());
	}

	/**
	 * Returns results after roundup
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(pointcut = "execution(* com.weather.*.Processor.roundUp(..))", returning = "result")
	public void logFieldData(JoinPoint joinPoint, Object result) {
		log.info("Result " + result.toString());
	}

	/**
	 * Logging for unzip
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(pointcut = "execution(* com.weather.*.Unzip.unzipAndReadFile(..))", returning = "result")
	public void logFieldDatas(JoinPoint joinPoint, Object result) {
		log.info("Calling Method : " + joinPoint.getSignature().toShortString());
	}

	/**
	 * Exception logging
	 * @param joinPoint
	 * @param error
	 */
	@AfterThrowing(pointcut = "execution(* com.weather.*.*(..))", throwing = "error")
	public void logException(JoinPoint joinPoint, Throwable error) {
		log.info("Method Signature: " + joinPoint.getSignature());
		log.info("Exception is: " + error);
	}

}
