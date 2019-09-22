package com.study.mybatis9;

import java.util.List;

public interface IStudentDao {
	List<Student> selectStusByIf(Student student);
	
	List<Student> selectStusByWhere(Student student);
	
	List<Student> selectStusByChoose(Student student);
	
	List<Student> selectStusByForeach(int[] ids);
	
	List<Student> selectStusByForeach2(List<Integer> list);
	
	List<Student> selectStusByForeach3(List<Student> list);
}
