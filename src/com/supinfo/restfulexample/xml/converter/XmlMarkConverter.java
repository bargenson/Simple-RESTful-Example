package com.supinfo.restfulexample.xml.converter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.supinfo.restfulexample.entity.Mark;
import com.supinfo.restfulexample.xml.XmlMark;

public class XmlMarkConverter implements XmlConverter<XmlMark, Mark> {

	private Mapper mapper = new DozerBeanMapper();
	
	
	@Override
	public XmlMark convertToXml(Mark obj) {
		return mapper.map(obj, XmlMark.class);
	}

	@Override
	public Mark convertFromXml(XmlMark xmlObj) {
		return mapper.map(xmlObj, Mark.class);
	}

}
