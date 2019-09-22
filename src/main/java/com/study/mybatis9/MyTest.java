package com.study.mybatis9;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {
	IStudentDao dao;
	private SqlSession sqlSession;

	/**
	 * @Before和@After被 @BeforeEach和@AfterEach给替代了
	 *                 莫名原因,在这里之只能使用@BeforeEach,而前面包的MyTest中却可以继续使用@Before
	 */
	@BeforeEach
	public void before() {
		// 获取sqlSession
		sqlSession = new MyBatisUtils().getSqlSession();
		// 获取mapper
		// dao = sqlSession.getMapper(com.study.mybatis6.IStudentDao.class);
		dao = sqlSession.getMapper(IStudentDao.class);
	}

	// 在这里也只能使用@AfterEach,@Before失效
	@AfterEach
	public void after() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectStusByIf() {
		Student student = new Student("小万",23,90);
		List<Student> stusList = dao.selectStusByIf(student );
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStusByWhere() {
		Student student = new Student("",23,90);
		List<Student> stusList = dao.selectStusByWhere(student);
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStusByChoose() {
//		Student student = new Student("小万",0,0);
//		Student student = new Student("",23,0);
//		Student student = new Student("",0,90);
		Student student = new Student("",0,0);
		List<Student> stusList = dao.selectStusByChoose(student);
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStusByForeach() {
		int[] ids = {1,3,5};
		List<Student> stusList = dao.selectStusByForeach(ids);
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStusByForeach2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		List<Student> stusList = dao.selectStusByForeach2(list);
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testSelectStusByForeach3() {
		List<Student> list = new ArrayList<Student>();
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		stu1.setId(1);
		stu2.setId(3);
		stu3.setId(5);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		List<Student> stusList = dao.selectStusByForeach3(list);
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
}
