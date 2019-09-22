package com.study.mybatis18;

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
	 * 	MyBatis的查询缓存机制，分为一级缓存和二级缓存。
	 * 	MyBatis查询缓存的作用域是根据映射文件mapper的namespace划分的，相同namespace的mapper查询缓存数据存放在同一个
	 * 	缓存区域。不同namespace下的数据互不干扰。无论是一级缓存还是二级缓存，都是按照namespace进行分别存放的
	 * 	但一、二级缓存的不同之处在于，SqlSession一旦关闭，则SqlSession中的数据将不存在，即一级缓存就不覆存在。而二级缓存的生
	 * 	命周期会与整个应用同步，与SqlSession是否关闭无关。换句话说，一级缓存是同一线程（同一Session）间共享数据，而二级缓存是
	 * 	不同线程（不同SqlSession）间共享数据。
	 * 
	 * 	缓存的底层是一个Map，Map的value是查询结果。
	 * 	Map的key，即查询依据，使用的ORM框架不同，查询依据是不同的。
	 * 	MaBatis的查询依据是：哈希值，SQL（select语句）的id和SQL语句。
	 * 	Hibernate的查询依据是：查询结果对象的id。
	 * 
	 * 	一级缓存不用设置，默认自动开启。
	 * 	当一个SqlSession结束后（关闭，调用close（）后），该SqlSession中的一级缓存也就不存在了。
	 * 
	 * 	注意：增删改操作无论是否进行事务提交，均会清空缓存（一级缓存二级缓存均会被清空）。
	 * 
	 * 	二级缓存需要手动配置。
	 * 	由于MaBatis从缓存中读取数据的依据与SQL的id相关，而非查询出的对象。所以，使用二级缓存的目的，不是在多个查询间共享查询结果
	 * 	（所有查询中只要查询结果中存在该对象的，就直接从缓存中读取，这是对查询结果的共享，Hibernate中的缓存就是为了在多个查询缉间
	 * 	共享查询结果，但MyBatis的不是），而是为了防止同一查询（相同的哈希值、相同的SQL id、相同的SQL语句的反复执行）
	 * 	MaBatis内置的二级缓存为org.apache.ibatis.cache.impl.PerpetualCache.class
	 * 	开启内置二级缓存的步骤：
	 * 		1.对实体进行序列化，即实现Serializable接口
	 * 		2.在映射文件mapper中添加<cache/>标签
	 * 	二级缓存的使用原则：
	 * 		1.多个namespace不要操作同一张表
	 * 			由于二级缓存中的数据是基于namespace的，即不同namespace中的数据互不干扰。用用户在某个namespace下对表执
	 * 			行了增删改操作，该操作只会引发当前namespace下的二级缓存的刷新，而对其它namespace下的二级缓存没有影响。这样
	 * 			的话，其他二级缓存中的数据依然是未更新的数据，也就出现了多个namespace中的数据不一致的现象。
	 * 
	 * 	使用ehcache第三方二级缓存包
	 * 	1.导入ehcache-core和mybatis-ehcache
	 * 	2.添加ehcache.xml配置文件
	 * 	3.在mapper映射文件中的ehcache标签中设置type属性值为ehcache工具类
	 * 		<ehcache type="org.mybatis.caches.ehcache.EhcacheCache"/>
	 */

	@Test
	public void testSelectCountryById() {
		Country country = dao.selectCountryById(1);
		System.out.println(country);
	}

}
