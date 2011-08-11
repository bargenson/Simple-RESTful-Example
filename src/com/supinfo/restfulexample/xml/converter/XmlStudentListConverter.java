package com.supinfo.restfulexample.xml.converter;

import java.util.ArrayList;
import java.util.List;

import com.supinfo.restfulexample.entity.Student;
import com.supinfo.restfulexample.xml.XmlStudent;
import com.supinfo.restfulexample.xml.XmlStudentList;

public class XmlStudentListConverter implements XmlConverter<XmlStudentList, List<Student>> {

	private XmlStudentConverter converter = new XmlStudentConverter();

	
	@Override
	public XmlStudentList convertToXml(List<Student> students) {
		List<XmlStudent> xmlStudents = new ArrayList<XmlStudent>();
		
		for (Student student : students) {
			xmlStudents.add(converter.convertToXml(student));
		}
		
		return new XmlStudentList(xmlStudents);
	}

	@Override
	public List<Student> convertFromXml(XmlStudentList xmlStudents) {
		List<Student> students = new ArrayList<Student>();
		
		for (XmlStudent xmlStudent : xmlStudents.getStudents()) {
			students.add(converter.convertFromXml(xmlStudent));
		}
		
		return students;
	}
	
}
