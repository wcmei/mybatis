package com.study.mybatis18;

import java.util.Set;

public class Country {
	private Integer cid;
	private String cname;
	// 一对多关联属性
	private Set<Minister> ministers;

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public final Integer getCid() {
		return cid;
	}

	public final void setCid(Integer cid) {
		this.cid = cid;
	}

	public final String getCname() {
		return cname;
	}

	public final void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
	}

}
