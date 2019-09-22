package com.study.mybatis4;

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
	public void testInsertStu() {
		dao = new IStudentDaoImpl();
		Student stu = new Student("小万", 23, 93);
		System.out.println("插入前:Student: " + stu); // 插入前:Student: Student [id=null, name=小万, age=23, score=93.0]
		dao.insertStu(stu);
		System.out.println("插入后:Student: " + stu); // 插入后:Student: Student [id=null, name=小万, age=23, score=93.0]
	}

	@Test
	public void testInsertStuCacheId() {
		dao = new IStudentDaoImpl();
		Student stu = new Student("小万", 23, 93);
		System.out.println("插入前:Student: " + stu); // 插入前:Student: Student [id=null, name=小万, age=23, score=93.0]
		dao.insertStuCacheId(stu);
		System.out.println("插入后:Student: " + stu); // 插入后:Student: Student [id=28, name=小万, age=23, score=93.0]
	}

	@Test
	public void testDeleteStuById() {
		dao = new IStudentDaoImpl();
		dao.deleteStuById(31);
	}

	@Test
	public void testUpdateStu() {
		dao = new IStudentDaoImpl();
		Student stu = new Student(30,"大万", 23, 93);
		dao.updateStu(stu);
	}
	
	@Test
	public void testSelectAllStus() {
		dao = new IStudentDaoImpl();
		List<Student> stusList = dao.selectAllStus();
		for(Student stu: stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStuById() {
		dao = new IStudentDaoImpl();
		Student stu = dao.selectStuById(28);
		System.out.println(stu);
	}
	
	@Test
	public void testSelectStusByName() {
		dao = new IStudentDaoImpl();
		List<Student> stusList = dao.selectStusByName("小");
		for(Student stu: stusList) {
			System.out.println(stu);
		}
	}
}
