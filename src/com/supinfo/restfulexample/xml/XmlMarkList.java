package com.supinfo.restfulexample.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="marks")
public class XmlMarkList implements Serializable {
	
	private List<XmlMark> marks;
	

	public XmlMarkList() {
		
	}
	
	public XmlMarkList(List<XmlMark> marks) {
		this.marks = marks;
	}
	
	@XmlElement(name="mark")
	public List<XmlMark> getMarks() {
		return marks;
	}
	
	public void setMarks(List<XmlMark> marks) {
		this.marks = marks;
	}
	
	@XmlElement
	public int getCount() {
		return marks.size();
	}

}
