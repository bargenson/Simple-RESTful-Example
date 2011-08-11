package com.supinfo.restfulexample.rest;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.supinfo.restfulexample.dao.DaoFactory;
import com.supinfo.restfulexample.dao.StudentDao;
import com.supinfo.restfulexample.exception.ItemAlreadyExistException;
import com.supinfo.restfulexample.exception.UnknownItemException;
import com.supinfo.restfulexample.xml.XmlStudent;
import com.supinfo.restfulexample.xml.XmlStudentList;
import com.supinfo.restfulexample.xml.converter.XmlStudentConverter;
import com.supinfo.restfulexample.xml.converter.XmlStudentListConverter;

@Path("/students")
public class StudentResource {
	
	private StudentDao studentDao;
	private XmlStudentConverter xmlStudentConverter;
	private XmlStudentListConverter xmlStudentListConverter;
	
	
	public StudentResource() {
		this.studentDao = DaoFactory.getInstance().getStudentDao();
		this.xmlStudentConverter = new XmlStudentConverter();
		this.xmlStudentListConverter = new XmlStudentListConverter();
	}
	
	@GET
	public XmlStudentList getAllStudents() {
		return xmlStudentListConverter.convertToXml(studentDao.getAllStudents());
	}
	
	@POST
	public Response addStudent(XmlStudent student) {
		try {
			studentDao.addStudent(xmlStudentConverter.convertFromXml(student));
		} catch (ItemAlreadyExistException e) {
			throw new WebApplicationException(e, 403);
		}
		return Response.created(URI.create("/" + student.getIdBooster())).build();
	}

	@GET
	@Path("/{idBooster}")
	public XmlStudent findStudentByIdBooster(@PathParam("idBooster") Long idBooster) {
		try {
			return xmlStudentConverter.convertToXml(studentDao.findStudentByIdBooster(idBooster));
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@PUT
	@Path("/{idBooster}")
	public void updateStudent(XmlStudent student) {
		try {
			studentDao.updateStudent(xmlStudentConverter.convertFromXml(student));
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@DELETE
	@Path("/{idBooster}")
	public void removeStudent(@PathParam("idBooster") Long idBooster) {
		try {
			studentDao.removeStudentByIdBooster(idBooster);
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@GET
	@Path("/search/{query}")
	public XmlStudentList searchStudent(@PathParam("query") String query) {
		return xmlStudentListConverter.convertToXml(studentDao.searchStudent(query));
	}

}
