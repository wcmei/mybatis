package com.study.mybatis1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class IStudentDaoImpl implements IStudentDao {
	
	SqlSession sqlSession;
	@Override
	public void insertStu(Student student) {
		try {
			// 1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("mybatis_1.xml");
			// 2.创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 3.创建SqlSession对象
			sqlSession = sqlSessionFactory.openSession();
			// 4.相关操作
			sqlSession.insert("insertStudent",student);
			// 
			sqlSession.commit(); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
