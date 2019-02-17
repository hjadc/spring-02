package com.huju.aop.demo1.aop_formal_xml;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void find() {
		System.out.println("查询客户...");
		int a = 1/0;
	}

	@Override
	public void save() {
		System.out.println("保存客户...");
	}

	@Override
	public void update() {
		System.out.println("修改客户...");
	}

	@Override
	public String delete() {
		System.out.println("删除客户...");
		return "德玛西亚";
	}
}
