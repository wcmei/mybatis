package com.study.mybatis14;

import java.util.Set;

// 新闻栏目:当前的新闻栏目被看作是一方:即父栏目
public class NewsLabel {
	private Integer id;
	private String name; // 栏目名称
	private Set<NewsLabel> children;

	public NewsLabel() {
		// TODO Auto-generated constructor stub
	}

	public NewsLabel(Integer id, String name, Set<NewsLabel> children) {
		super();
		this.id = id;
		this.name = name;
		this.children = children;
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

	public Set<NewsLabel> getChildren() {
		return children;
	}

	public void setChildren(Set<NewsLabel> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", children=" + children + "]";
	}

}
