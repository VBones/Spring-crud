package com.bones.springcrud.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class EmployeeAspects {

	@Autowired
	private HttpSession session;
	
	@AfterReturning("com.bones.springcrud.aspect.PointcutExpressions.forDeleteEmployee()")
	private void increaseFiredCount() {
		
		if (session.getAttribute("firedCount") == null) {
			session.setAttribute("firedCount", new Integer(1));
		}
		else {
			session.setAttribute("firedCount", new Integer(((Integer)session.getAttribute("firedCount"))+1));
		}
	}
}
