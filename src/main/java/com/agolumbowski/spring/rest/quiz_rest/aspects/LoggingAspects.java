package com.agolumbowski.spring.rest.quiz_rest.aspects;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author agolu
 */
@Aspect
@Component
public class LoggingAspects {

    private final Logger logger = LogManager.getLogger();

    @Before("execution(* com.agolumbowski.spring.rest.quiz_rest.service..*(..))")
    public void beforeAllMethods(JoinPoint joinPoint) {

        logger.log(Level.INFO, "trying to execute method " + joinPoint.getSignature() + " args: ");
        logger.log(Level.INFO, joinPoint.getArgs());

    }
}
