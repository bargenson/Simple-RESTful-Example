package com.supinfo.restfulexample.xml;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class XmlStudent implements Serializable {
	
	private Long idBooster;
	private String firstName;
	private String lastName;
	private Date birthDate;

	public XmlStudent() {
		
	}

	public Long getIdBooster() {
		return idBooster;
	}

	public void setIdBooster(Long idBooster) {
		this.idBooster = idBooster;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
