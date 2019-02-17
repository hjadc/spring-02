package com.huju.aop.demo1.aop_jdk_proxy;

import org.junit.Test;

/**
 * jdk动态代理原理 (实际上是不需要自己写的,配置一下就行)
 * @author huju
 *
 */
public class SpringDemo1 {
	
	/**
	 * 传统方法
	 */
	@Test
	public void demo1(){
		UserDao userDao = new UserDaoImpl();
		userDao.find();
		userDao.save();
		userDao.update();
		userDao.delete();
	}
	
	/**
	 * 交给jdk的动态代理,对其进行增强
	 */
	@Test
	public void demo2(){
		UserDao userDao = new UserDaoImpl();
		UserDao proxy = new JdkProxy(userDao).createProxy();
		
		proxy.find();
		proxy.save();
		proxy.update();
		proxy.delete();
	}

}
