package com.study.mybatis17;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {
	ICountryDao dao;
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
		dao = sqlSession.getMapper(ICountryDao.class);
	}

	// 在这里也只能使用@AfterEach,@Before失效
	@AfterEach
	public void after() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	/*
	 * 直接加载：执行完对主加载对象的select语句，马上执行对关联对象的select语句。（未开启延迟加载总开关）
	 * 侵入式延迟：执行完对主加载对象的select语句时，不会马上执行对关联对象的select语句。
	 * 		   但当要访问主加载对象的详情时，就会马上执行的关联对象的select语句。
	 * 		  （设置lazyLoadingEnabled为true，aggressiveLazyLoading为true）
	 * 深入延迟：执行完对主加载对象的select语句时，不会马上执行对关联对象的select语句。
	 * 		   只有当访问关联对象的详情时，才会执行对关联的select语句
	 * 		  （设置lazyLoadingEnabled为true，aggressiveLazyLoading为false）
	 * 多表连接查询时，无法使用延迟加载，因为只有一个select语句。
	 */

	@Test
	public void testSelectCountryById() {
		Country country = dao.selectCountryById(1);
		System.out.println(country);
	}

}
