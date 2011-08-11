package com.supinfo.restfulexample.dao;

import java.util.List;

import com.supinfo.restfulexample.entity.Student;

public interface StudentDao {
	
	void addStudent(Student student);
	Student findStudentByIdBooster(Long idBooster);
	void updateStudent(Student student);
	void removeStudentByIdBooster(Long idBooster);
	void removeStudent(Student student);
	List<Student> getAllStudents();
	List<Student> searchStudent(String query);

}
