package com.supinfo.restfulexample.xml.converter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.supinfo.restfulexample.entity.Student;
import com.supinfo.restfulexample.xml.XmlStudent;

public class XmlStudentConverter implements XmlConverter<XmlStudent, Student> {

	private Mapper mapper = new DozerBeanMapper();
	
	
	@Override
	public XmlStudent convertToXml(Student student) {
		return mapper.map(student, XmlStudent.class);
	}

	@Override
	public Student convertFromXml(XmlStudent xmlObj) {
		return mapper.map(xmlObj, Student.class);
	}

}
