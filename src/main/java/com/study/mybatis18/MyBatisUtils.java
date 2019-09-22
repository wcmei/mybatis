package com.study.mybatis18;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	SqlSessionFactory sqlSessionFactory;

	public SqlSession getSqlSession() {
		// 1.加载主配置文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis_18.xml");
			// 2.创建SqlSessionFactory对象
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
