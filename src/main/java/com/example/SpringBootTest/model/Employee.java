package com.example.SpringBootTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_RECORD")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private Long eId;
	
	@Column(name = "username")
	private String user;
	
	@Column(name = "password")
	private String password;

	public Long geteId() {
		return eId;
	}
/*
	public void seteId(Integer eId) {
		this.eId = eId;
	}*/

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
