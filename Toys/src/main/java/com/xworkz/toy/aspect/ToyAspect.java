package com.xworkz.toy.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
//@Log4j2
@Slf4j
public class ToyAspect {
	
Logger	log=LoggerFactory.getLogger(ToyAspect.class);
	

@Before(value= "execution(* com.xworkz.toy.service.ToyServiceImpl.*(..))")	
public void beforeAdvice(JoinPoint jp) {
	log.error("Before..");
log.info("First logging message");
log.warn("Dto is not null...");
log.info("The method executing is : "+jp.getSignature().getName());	
}


@After(value= "execution(* com.xworkz.toy.service.ToyServiceImpl.*(..))")	
public void afterAdvice(JoinPoint jp) {
	System.out.println("After.. "+jp.getStaticPart().getKind());
	System.out.println("Dto saved into DB ....");
System.out.print("The method is : "+jp.getSignature());	
}


@AfterReturning(pointcut =  "execution(* com.xworkz.toy.service.ToyServiceImpl.*(..))",returning = "result")	
public void afterAdvice(JoinPoint jp,Object result) {
	System.out.println("After.. "+jp.getStaticPart().getKind());
	log.warn("Dto can be null...");
	System.out.println("Dto saved into DB ....");
System.out.println(jp.getSignature());	
System.out.println("After the execution of this method the result is: "+result);
}
}


