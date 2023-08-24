package com.crud.model;

public class Student implements Comparable<Student> {

	Integer rollNo;
	String fname;
	String lName;
	String collegeName;

	public Student(Integer rollNo, String fname, String lName, String collegeName) {
		this.rollNo = rollNo;
		this.fname = fname;
		this.lName = lName;
		this.collegeName = collegeName;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public int compareTo(Student student) {
		return this.rollNo-student.rollNo;
	}

}
