package com.supinfo.restfulexample.rest;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.supinfo.restfulexample.dao.DaoFactory;
import com.supinfo.restfulexample.dao.MarkDao;
import com.supinfo.restfulexample.entity.Mark;
import com.supinfo.restfulexample.exception.UnknownItemException;
import com.supinfo.restfulexample.xml.XmlMark;
import com.supinfo.restfulexample.xml.XmlMarkList;
import com.supinfo.restfulexample.xml.converter.XmlMarkConverter;
import com.supinfo.restfulexample.xml.converter.XmlMarkListConverter;

@Path("/students/{idBooster}/marks")
public class MarkResource {
	
	private XmlMarkConverter xmlMarkConverter;
	private XmlMarkListConverter xmlMarkListConverter;
	private MarkDao markDao;
	
	public MarkResource() {
		this.markDao = DaoFactory.getInstance().getMarkDao();
		this.xmlMarkConverter = new XmlMarkConverter();
		this.xmlMarkListConverter = new XmlMarkListConverter();
	}
	
	@GET
	public XmlMarkList getAllMarks(@PathParam("idBooster") Long idBooster) {
		try {
			return xmlMarkListConverter.convertToXml(markDao.findAllMarksByIdBooster(idBooster));
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@POST
	public Response addMark(@PathParam("idBooster") Long idBooster, XmlMark xmlMark) {
		try {
			Mark mark = markDao.addMark(idBooster, xmlMarkConverter.convertFromXml(xmlMark));
			return Response.created(URI.create("/" + mark.getKey())).build();
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@GET
	@Path("/{markKey}")
	public XmlMark findMarkByKey(@PathParam("markKey") String markKey) {
		try {
			return xmlMarkConverter.convertToXml(markDao.findMarkByKey(markKey));
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}
	
	@DELETE
	@Path("/{markKey}")
	public void removeMark(@PathParam("markKey") String markKey) {
		try {
			markDao.removeMark(markKey);
		} catch (UnknownItemException e) {
			throw new WebApplicationException(e, 404);
		}
	}

}
