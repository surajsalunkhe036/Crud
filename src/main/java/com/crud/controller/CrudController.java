package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Student;
import com.crud.service.CrudService;

@RestController
@RequestMapping("/students")
public class CrudController {

	@Autowired
	CrudService service;

	/**
	 * @return List of Students by default sorted by roll no using comparable.
	 */
	@GetMapping()
	public List<Student> getStudentList() {
		return service.getStudentList();
	}

	/**
	 * @return List of Students sorted by first name using FirstName Comparator.
	 */
	@GetMapping("/sortedbyfname")
	public List<Student> getStudentListSortedByFirstName() {
		return service.getStudentListSortedByFName();
	}

	/**
	 * Return student info fetched by rollno
	 * @param rollno
	 * @return
	 */
	@GetMapping("/{rollno}")
	public Student getStudentByRollNo(@PathVariable Integer rollno) {
		return service.getStudentByRollNo(rollno);
	}

	/**
	 * Update student details using Http.Put method and we are passing whole student data and roll no as path variable.
	 * @param student
	 * @param rollno
	 * @return
	 */
	@PutMapping("/update/{rollno}")
	public List<Student> updateuByPutMethod(@RequestBody Student student, @PathVariable Integer rollno) {
		return service.updateStudentByRollNo(rollno,student);
	}
	
	/**
	 * Update student details using Http.Patch method and we are passing student details in body and roll no as path variable.
	 * @param student
	 * @param rollno
	 * @return
	 */
	@PatchMapping("/updateStud/{rollno}")
	public List<Student> updateByPatchMethod(@RequestBody Student student, @PathVariable Integer rollno) {
		return service.updateStudentByRollNo(rollno,student);
	}
	
	/**
	 * Remove Student details from list of students using Http.Delet method 
	 * @param rollno
	 * @return
	 */
	@DeleteMapping("/remove/{rollno}")
	public List<Student> removeStudentByID(@PathVariable Integer rollno) {
		return service.removeStudentByRollNo(rollno);
	}
}
