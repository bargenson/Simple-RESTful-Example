package com.supinfo.restfulexample.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="students")
public class XmlStudentList {
	
	private List<XmlStudent> students;
	

	public XmlStudentList() {
		
	}
	
	public XmlStudentList(List<XmlStudent> students) {
		this.students = students;
	}
	
	@XmlElement(name="student")
	public List<XmlStudent> getStudents() {
		return students;
	}
	
	public void setStudents(List<XmlStudent> students) {
		this.students = students;
	}
	
	@XmlElement
	public int getCount() {
		return students.size();
	}

}
