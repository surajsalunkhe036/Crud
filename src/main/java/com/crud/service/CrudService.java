package com.crud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.model.FirstNameComparator;
import com.crud.model.Student;

@Service
public class CrudService {

	static Map<Integer, Student> list = new HashMap<>();
	
	static{
		list.put(10, new Student(10, "Suraj", "Salunkhe", "SGI"));
		list.put(20, new Student(20, "Vijay", "Salunkhe", "Shivaji"));
		list.put(30, new Student(30, "Vikrant", "Salunkhe", "DYP"));
		list.put(40, new Student(40, "Shubham", "Parte", "YC"));
		list.put(50, new Student(50, "Akshay", "Parte", "DG"));
	}

	public List<Student> getStudentList() {
		return list.values().stream().sorted().collect(Collectors.toList());
	}

	public List<Student> getStudentListSortedByFName() {
		return list.values().stream().sorted(new FirstNameComparator()).collect(Collectors.toList());
	}
	
	public Student getStudentByRollNo(Integer rollno) {
		return list.get(rollno);
	}

	public List<Student> removeStudentByRollNo(Integer rollno) {
		list.remove(rollno);
		return list.values().stream().sorted().collect(Collectors.toList());
	}

	public List<Student> updateStudentByRollNo(Integer rollno, Student student) {
		Optional<Student> studentData = Optional.ofNullable(list.get(rollno));
		studentData.ifPresent(s -> {
			s.setFname(student.getFname());
			s.setlName(student.getlName());
			s.setCollegeName(student.getCollegeName());
		});
		
		if(!studentData.isEmpty()) {
			list.put(rollno, studentData.get());
		}
		return list.values().stream().sorted().collect(Collectors.toList());
	}
}
