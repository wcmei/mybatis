package com.study.mybatis5;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class IStudentDaoImpl implements IStudentDao {

	SqlSession sqlSession;


	@Override
	public List<Student> selectAllStus() {
		List<Student> stusList = null;
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			stusList = sqlSession.selectList("selectAllStus");
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return stusList;
	}

}
