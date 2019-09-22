package com.study.mybatis6;

import java.util.List;

public interface IStudentDao {
	// 插入
	void insertStu(Student student);

	// 获取ID插入
	void insertStuCacheId(Student student);

	// 删除
	void deleteStuById(int id);

	// 更新
	void updateStu(Student student);

	// 查询所有
	List<Student> selectAllStus();

	// 根据id查询
	Student selectStuById(int id);

	// 根据name模糊查询
	List<Student> selectStusByName(String name);

}
