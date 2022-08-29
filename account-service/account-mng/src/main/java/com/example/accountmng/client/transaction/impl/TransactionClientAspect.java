package com.example.accountmng.client.transaction.impl;

import com.example.accountmng.util.ClientExceptionUtils;
import com.example.common.exception.ClientException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TransactionClientAspect {

	@Before("within(com.example.accountmng.client.transaction.Transaction*Client+) & execution(*)")
	public void init(JoinPoint joinPoint) {
		log.debug("invoke {} - {}", joinPoint.getSignature().getName(), joinPoint.getArgs()[0]);
	}

	@AfterReturning(pointcut = "within(com.example.accountmng.client.transaction.Transaction*Client+) & execution(*)",
			returning = "response")
	public void verify(Object response) {
		log.debug("received {}", response);
	}

	@AfterThrowing(pointcut = "within(com.example.accountmng.client.transaction.Transaction*Client+) & execution(*)", throwing = "ex")
	public void handle(FeignException ex) throws ClientException {
		log.error("error occurred: ", ex);
		throw ClientExceptionUtils.deliver(ex);
	}

}
