package com.study.mybatis13;

public class Minister {
	private Integer mid;
	private String mname;
	// 多对一关联属性
	private Country country;

	public Minister() {
		// TODO Auto-generated constructor stub
	}

	public Minister(Integer mid, String mname,Country country) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.country = country;
	}

	public final Country getCountry() {
		return country;
	}

	public final void setCountry(Country country) {
		this.country = country;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + ", country=" + country + "]";
	}

	

}
