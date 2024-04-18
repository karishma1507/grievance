package com.tns.fm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
	
	@Id
	String email;
	String name;
	String password;
	public Member() {
		super();
	}
	public Member(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", password=" + password + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
