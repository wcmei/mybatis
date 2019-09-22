package com.study.mybatis16;

import java.util.Set;

public class Student {
	private Integer sid;
	private String sname;
	private Set<Course> courses;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer sid, String sname, Set<Course> courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.courses = courses;
	}

	public final Integer getSid() {
		return sid;
	}

	public final void setSid(Integer sid) {
		this.sid = sid;
	}

	public final String getSname() {
		return sname;
	}

	public final void setSname(String sname) {
		this.sname = sname;
	}

	public final Set<Course> getCourses() {
		return courses;
	}

	public final void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}
}
