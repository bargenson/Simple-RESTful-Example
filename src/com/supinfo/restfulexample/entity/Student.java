package com.supinfo.restfulexample.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity @Searchable
public class Student implements Serializable {
	
	@Id @SearchableId
	private Long idBooster;
	
	@SearchableProperty
	private String firstName;
	
	@SearchableProperty
	private String lastName;
	
	@SearchableProperty(format="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@OneToMany(mappedBy="student")
	private List<Mark> marks;
	
	
	public Student() {
		
	}

	public Student(Long idBooster, String firstName, String lastName, Date birthDate) {
		this.idBooster = idBooster;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
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
	
	public List<Mark> getMarks() {
		return marks;
	}
	
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
