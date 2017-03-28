package com.perficient.employee.registration.entity;

import javax.persistence.Entity;

@Entity
public class Employee {

	private String name;
	
	
	private String sex;
	
	
	private String email;
	
	private String dob;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + ", email=" + email + ", dob=" + dob + "]";
	}

}
