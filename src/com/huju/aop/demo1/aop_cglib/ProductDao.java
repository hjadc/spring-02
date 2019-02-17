package com.huju.aop.demo1.aop_cglib;

public class ProductDao {

	public void find() {
		System.out.println("查询商品...");
	}

	public void save() {
		System.out.println("保存商品...");
	}

	public void update() {
		System.out.println("修改商品...");
	}

	public void delete() {
		System.out.println("删除商品...");
	}
}
