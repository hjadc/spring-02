package com.huju.aop.demo1.aop_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理
 * 
 * @author huju
 *
 */
public class JdkProxy {

	private UserDao userDao;

	public JdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao createProxy() {
		UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				userDao.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
						if (method.getName().equals("save")) {
							System.out.println("权限校验=========");
						}
						return method.invoke(userDao, args);
					}
				});

		return proxy;
	}
}
