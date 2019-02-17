package com.huju.aop.demo1.aop_jdk_proxy;

public class UserDaoImpl implements UserDao {

	@Override
	public void find() {
		System.out.println("查询用户...");
	}

	@Override
	public void save() {
		System.out.println("保存用户...");
	}

	@Override
	public void update() {
		System.out.println("修改用户...");
	}

	@Override
	public void delete() {
		System.out.println("删除用户...");
	}

}