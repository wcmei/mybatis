package com.study.mybatis7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void testSelectStusByName() {
		Student student = new Student("小万",23,90);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameCon", "万");
		map.put("ageCon", 23);
		map.put("scoreCon", student);
		List<Student> stusList = dao.selectStusByCondition(map );
		for (Student stu : stusList) {
			System.out.println(stu);
		}
	}
}
