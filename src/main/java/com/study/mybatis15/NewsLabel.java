package com.study.mybatis15;

import java.util.Set;

// 新闻栏目:当前的新闻栏目被看作是多方:即子栏目
public class NewsLabel {
	private Integer id;
	private String name; // 栏目名称
	private NewsLabel parent;

	public NewsLabel() {
		// TODO Auto-generated constructor stub
	}

	public NewsLabel(Integer id, String name, NewsLabel parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewsLabel getParent() {
		return parent;
	}

	public void getParent(NewsLabel parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}

}
