package com.study.mybatis19;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface IStudentDao {
	// 插入
	@Insert(value = { "insert into student(name,age,score) values(#{name},#{age},#{score})" })
	void insertStu(Student student);

	// 获取ID插入
	@Insert("insert into student(name,age,score) values(#{name},#{age},#{score})")
	@SelectKey(statement = "select @@identity",resultType = int.class,keyProperty = "id",before = false)
	void insertStuCacheId(Student student);

	// 删除,只有一个字符串大括号可以省略不写
	@Delete(value = "delete from student where id = #{xxx} ")
	void deleteStuById(int id);

	// 更新,只有一个value属性，那么value也可以省略不写
	@Update("update student set name=#{name} where id=#{id}")
	void updateStu(Student student);

	// 查询所有
	@Select("select * from student")
	List<Student> selectAllStus();

	// 根据id查询
	@Select("select * from student where id=#{ooo}")
	Student selectStuById(int id);

	// 根据name模糊查询
	@Select("select * from student where name like '%' #{xxx} '%'")
	List<Student> selectStusByName(String name);

}
