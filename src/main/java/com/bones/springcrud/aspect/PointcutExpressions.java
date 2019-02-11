package com.bones.springcrud.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

	@Pointcut("execution(* com.bones.springcrud.controller.EmployeeController.deleteEmployee(..))")
	public void forDeleteEmployee() {}
}
