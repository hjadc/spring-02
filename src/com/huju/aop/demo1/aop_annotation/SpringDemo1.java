package com.huju.aop.demo1.aop_annotation;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 正式使用注解方式进行aop编程
 * @author huju
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {
	
	@Resource(name="myCustomerDao")
	private MyCustomerDao myCustomerDao;
	
	@Test
	public void demo1() {
		myCustomerDao.save();
		myCustomerDao.find();
		myCustomerDao.update();
		myCustomerDao.delete();
	}

}
