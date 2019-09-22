package com.study.mybatis4;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class IStudentDaoImpl implements IStudentDao {

	SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			sqlSession.insert("insertStu", student);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void insertStuCacheId(Student student) {
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			sqlSession.insert("insertStuCacheId", student);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void deleteStuById(int id) {
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			sqlSession.delete("deleteStuById", id);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateStu(Student student) {
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			sqlSession.update("updateStu", student);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

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

	@Override
	public Student selectStuById(int id) {
		Student stu = null;
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			stu = sqlSession.selectOne("selectStuById", id);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return stu;
	}

	@Override
	public List<Student> selectStusByName(String name) {
		List<Student> stusList = null;
		try {
			sqlSession = new MyBatisUtils().getSqlSession();
			stusList = sqlSession.selectList("selectStusByName",name);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return stusList;
	}

}
