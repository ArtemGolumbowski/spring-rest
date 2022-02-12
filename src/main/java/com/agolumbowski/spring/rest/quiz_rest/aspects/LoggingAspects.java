
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
    
    
    @Before("execution(public com.agolumbowski.spring.rest.quiz_rest.entity.Subject read(..))")
    public void beforeAllMethods(JoinPoint joinPoint){
      
        logger.log(Level.INFO, joinPoint.getSignature()+"------------------------------------------");

    }
}
