package com.huju.aop.demo1.aop_formal_xml;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 正式使用xml方式进行aop编程
 * @author huju
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo3 {
	
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Test
	public void demo1(){
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");*/
		customerDao.find();
		customerDao.save();
		customerDao.update();
		customerDao.delete();
	}

}
