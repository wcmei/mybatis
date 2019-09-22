package com.study.mybatis15;

import java.util.List;

public interface INewsLabelDao {
	// 查询指定栏目及其父栏目
	List<NewsLabel> selectNewsLabelById(int id);
}
