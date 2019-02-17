package com.huju.aop.demo1.aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 注解式AOP的切面类 需要到spring里开启注解 <aop:aspectj-autoproxy/>
 * @Aspect就代表当前类是一个切面类
 * 
 * @author huju
 *
 */

@Aspect
public class MyAspectAnnotation {
	
	@Before(value="execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.save(..))")
	public void before() {
		System.out.println("前置增强========");
	}
	
	/**
	 * 后置增强, returning是目标方法的返回值
	 * @param obj
	 */
	@AfterReturning(value="execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.delete(..))", returning="obj")
	public void afterReturning(Object obj){
		System.out.println("后置增强========" + obj);
	}
	
	@Around(value="execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.update(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕前增强========");
		Object object = joinPoint.proceed();
		System.out.println("环绕后增强========");
		return object;
	}
	
	@AfterThrowing(value="execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.find(..))", throwing="throwable")
	public void afterThrowing(Throwable throwable){
		System.out.println("异常抛出增强=========,异常原因是: " + throwable.getMessage());
	}
	
	/**
	 * 最终增强,不管有没有异常,都会执行
	 */
	@After("execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.find(..))")
	public void after() {
		System.out.println("最终增强");
	}
	
	
	/**
	 * save方法的最终增强,不管有没有异常,都会执行
	 */
	@After(value="MyAspectAnnotation.pointcut1()")
	public void afterBySave() {
		System.out.println("save方法的最终增强=========");
	}
	
	/**
	 * 将切入点提取出来,用法如:save方法的最终增强
	 */
	@Pointcut("execution(* com.huju.aop.demo1.aop_annotation.MyCustomerDaoImpl.save(..))")
	private void pointcut1() {}

}
