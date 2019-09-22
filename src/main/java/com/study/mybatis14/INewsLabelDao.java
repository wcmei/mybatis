package com.study.mybatis14;

import java.util.List;

public interface INewsLabelDao {
	// 查询子栏目
	List<NewsLabel> selectChildrenByParent(int pid);
	// 查询指定栏目及其子栏目
	List<NewsLabel> selectNewsLabelById(int id);
}
