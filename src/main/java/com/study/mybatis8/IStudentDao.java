package com.study.mybatis8;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
	// 多条件查询(条件不能封装成对象情况)
	List<Student> selectStusByCondition(String name, int age, int score);

}
