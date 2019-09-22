package com.study.mybatis5;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MyTest {
	IStudentDao dao;

	@Before
	public void before() {
		dao = new IStudentDaoImpl();
	}

	@Test
	public void testSelectAllStus() {
		dao = new IStudentDaoImpl();
		List<Student> stusList = dao.selectAllStus();
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}

}
