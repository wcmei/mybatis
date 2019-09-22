package com.study.mybatis19;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
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
	public void testInsertStu() {
		Student stu = new Student("小万", 23, 93);
		System.out.println("插入前:Student: " + stu); // 插入前:Student: Student [id=null, name=小万, age=23, score=93.0]
		dao.insertStu(stu);
		System.out.println("插入后:Student: " + stu); // 插入后:Student: Student [id=null, name=小万, age=23, score=93.0]
		sqlSession.commit();
	}

	@Test
	public void testInsertStuCacheId() {
		Student stu = new Student("小万", 23, 93);
		System.out.println("插入前:Student: " + stu); // 插入前:Student: Student [id=null, name=小万, age=23, score=93.0]
		dao.insertStuCacheId(stu);
		System.out.println("插入后:Student: " + stu); // 插入后:Student: Student [id=28, name=小万, age=23, score=93.0]
		sqlSession.commit();
	}

	@Test
	public void testDeleteStuById() {
		dao.deleteStuById(31);
		sqlSession.commit();
	}

	@Test
	public void testUpdateStu() {
		Student stu = new Student(39, "大万", 23, 93);
		dao.updateStu(stu);
		sqlSession.commit();
	}

	@Test
	public void testSelectAllStus() {
		List<Student> stusList = dao.selectAllStus();
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}

	@Test
	public void testSelectStuById() {
		Student stu = dao.selectStuById(28);
		System.out.println(stu);
	}

	@Test
	public void testSelectStusByName() {
		List<Student> stusList = dao.selectStusByName("小");
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
}
