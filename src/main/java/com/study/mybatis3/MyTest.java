package com.study.mybatis3;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MyTest {
	IStudentDao dao;
	
	@Before
	public void before() {
		dao = new IStudentDaoImpl();
	}
	
	@Test
	public void testInsert() {
		dao = new IStudentDaoImpl();
		Student stu = new Student("小万",23,93);
		dao.insertStu(stu);
	}
}
