package com.aop.methods;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundMethod implements MethodInterceptor {
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		System.out.println("Method name : "
				+ methodInvocation.getMethod().getName());
		System.out.println("Method arguments : "
				+ Arrays.toString(methodInvocation.getArguments()));

		// same with MethodBeforeAdvice
		System.out.println("AroundMethod : Before method taken!");

		try {
			// proceed to original method call
			Object result = methodInvocation.proceed();

			// same with AfterReturningAdvice
			System.out.println("AroundMethod : Before after taken!");

			return result;

		} catch (IllegalArgumentException e) {
			// same with ThrowsAdvice
			System.out
					.println("AroundMethod : Throw exception taken!");
			throw e;
		}
	}
}