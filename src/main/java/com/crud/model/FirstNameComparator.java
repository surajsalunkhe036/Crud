package com.crud.model;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.fname.compareTo(o2.fname);
	}

}
