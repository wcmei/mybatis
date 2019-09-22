package com.study.mybatis18;

public class Minister {
	private Integer mid;
	private String mname;

	public Minister() {
		// TODO Auto-generated constructor stub
	}

	public Minister(Integer mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
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
		return "Minister [mid=" + mid + ", mname=" + mname + "]";
	}

}
