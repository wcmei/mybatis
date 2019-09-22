package com.study.mybatis15;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {
	INewsLabelDao dao;
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
		dao = sqlSession.getMapper(INewsLabelDao.class);
	}

	// 在这里也只能使用@AfterEach,@Before失效
	@AfterEach
	public void after() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectNewsLabelById() {
		List<NewsLabel> parent = dao.selectNewsLabelById(5);
		for (NewsLabel newsLabel : parent) {
			System.out.println(newsLabel);
		}
	}

}
