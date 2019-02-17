package com.huju.aop.demo1.aop_cglib;

import org.junit.Test;

import com.huju.aop.demo1.aop_jdk_proxy.UserDao;
import com.huju.aop.demo1.aop_jdk_proxy.UserDaoImpl;

/**
 * cglib动态代理原理 (实际上是不需要自己写的,配置一下就行)
 * @author huju
 *
 */
public class SpringDemo2 {

	/**
	 * 传统方法
	 */
	@Test
	public void demo1() {
		ProductDao productDao = new ProductDao();
		productDao.find();
		productDao.save();
		productDao.update();
		productDao.delete();
	}

	/**
	 * 交给cglib的动态代理,对其进行增强
	 */
	@Test
	public void demo2() {
		ProductDao productDao = new ProductDao();
		ProductDao proxy = new CglibProxy(productDao).createProxy();
		proxy.find();
		proxy.save();
		proxy.update();
		proxy.delete();
	}
}
