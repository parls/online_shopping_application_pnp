package net.parls.pnpshoppingapplication.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	public Person(Long id) {
		this.id=id;
	}
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email",nullable = false,unique= true)
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile")
	private String phoneNo;
	
	private transient String confirmaPassword;
	
	public Person(String name, String email, String password, String phoneNo)
	{
		this.name = name;
		this.email  = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	
	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getConfirmaPassword() {
		return confirmaPassword;
	}

	public void setConfirmaPassword(String confirmaPassword) {
		this.confirmaPassword = confirmaPassword;
	}
	
}
