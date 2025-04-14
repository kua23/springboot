package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Students;
import com.student.repository.StudentsRepository;

@Service
public class StudentsService {
	@Autowired
	StudentsRepository student;
	
	public List<Students> getAllStudents(){
		return student.findAll();	
	}
	public Students getStudentId(Long id) {
		return student.findById(id).orElseThrow(() -> new RuntimeException("No student by that id"));
	}
	public void delStudentId(Long id) {
		student.findById(id).ifPresentOrElse(student::delete, () -> {throw new RuntimeException("No student by that id");});
	}
	public Students saveStudent(Students stud) {
		return student.save(stud);
	}
	public Students updateStudent(Long id, Students updated) {
		Students current = student.findById(id).orElseThrow(() -> new RuntimeException("No student by that id"));
		current.setName(updated.getName());
		current.setCourse(updated.getCourse());
		current.setEmail(updated.getEmail());
		return student.save(current);
	}
}
