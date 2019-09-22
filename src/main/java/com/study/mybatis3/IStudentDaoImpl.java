package com.study.mybatis3;

import org.apache.ibatis.session.SqlSession;

public class IStudentDaoImpl implements IStudentDao {
	
	SqlSession sqlSession;
	@Override
	public void insertStu(Student student) {
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			sqlSession.insert("insertStudent",student);
			sqlSession.commit(); 
			
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
