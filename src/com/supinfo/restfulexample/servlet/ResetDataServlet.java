package com.supinfo.restfulexample.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.restfulexample.dao.DaoFactory;
import com.supinfo.restfulexample.dao.StudentDao;
import com.supinfo.restfulexample.entity.Student;
import com.supinfo.restfulexample.search.CompassManager;

public class ResetDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		StudentDao studentDao = DaoFactory.getInstance().getStudentDao();
		
		List<Student> studentsToRemove = studentDao.getAllStudents();
		for (Student student : studentsToRemove) {
			studentDao.removeStudent(student);
		}
		
		List<Student> studentsToCreate = buildInitStudents();
		for (Student student : studentsToCreate) {
			studentDao.addStudent(student);
		}
		
		CompassManager.getInstance().index();
	}

	private List<Student> buildInitStudents() {
		List<Student> results = new ArrayList<Student>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(5287, 8, 15);
		
		results.add(new Student(59253L, "Jack", "Harkness", calendar.getTime()));
		
		calendar.set(1997, 7, 12);
		
		results.add(new Student(64543L, "Eric", "Cartman", calendar.getTime()));

		calendar.set(1946, 05, 28);
		
		results.add(new Student(65442L, "Joe", "Dalton", calendar.getTime()));
		
		return results;
	}

}
