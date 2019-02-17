package com.huju.aop.demo1.aop_formal_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 * 
 * @author huju
 *
 */
public class MyAspectXml {

	public void checkPrivilege() {
		System.out.println("权限校验完成了...");
	}
	
	public void writeLog() {
		System.out.println("日志记录完成了...");
	}
	
	
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知..." + joinPoint);
	}
	
	/**
	 * 后置通知
	 * @param result
	 */
	public void afterReturning(String result) {
		System.out.println("后置通知..." + result);
	}
	
	/**
	 * 环绕通知  可以阻止程序执行
	 * @param joinPoint
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("方法前通知======");
		Object obj = joinPoint.proceed();
		System.out.println("方法后通知======");
		
		return obj;
	}
	
	/**
	 * 异常抛出通知
	 */
	public void afterThrowing(Throwable throwable) {
		System.out.println("异常抛出通知======" + throwable.getMessage());
		// throwable.printStackTrace();
	}
	
	/**
	 * 最终通知  无论有没有异常,该方法都会执行
	 */
	public void after(){
		System.out.println("最终通知========");
	}

}
