package com.supinfo.restfulexample.xml.converter;

import java.util.ArrayList;
import java.util.List;

import com.supinfo.restfulexample.entity.Mark;
import com.supinfo.restfulexample.xml.XmlMark;
import com.supinfo.restfulexample.xml.XmlMarkList;

public class XmlMarkListConverter implements XmlConverter<XmlMarkList, List<Mark>> {

	private XmlMarkConverter converter = new XmlMarkConverter();

	@Override
	public XmlMarkList convertToXml(List<Mark> marks) {
		List<XmlMark> xmlMarks = new ArrayList<XmlMark>();

		for (Mark mark : marks) {
			xmlMarks.add(converter.convertToXml(mark));
		}

		return new XmlMarkList(xmlMarks);
	}

	@Override
	public List<Mark> convertFromXml(XmlMarkList xmlList) {
		List<Mark> marks = new ArrayList<Mark>();

		for (XmlMark xmlMark : xmlList.getMarks()) {
			marks.add(converter.convertFromXml(xmlMark));
		}

		return marks;
	}

}
