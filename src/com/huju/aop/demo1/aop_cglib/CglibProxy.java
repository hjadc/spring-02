package com.huju.aop.demo1.aop_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private ProductDao productDao;

	public CglibProxy(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductDao createProxy() {
		// 创建Cglib的产生代理核心类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(productDao.getClass());
		// 设置回调
		enhancer.setCallback(this);
		// 产生代理
		ProductDao proxy = (ProductDao) enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		if (method.getName().equals("save")) {
			System.out.println("权限校验===========");
		}
		return methodProxy.invokeSuper(proxy, args);
	}

}
