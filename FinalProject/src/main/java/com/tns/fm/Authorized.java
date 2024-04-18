package com.tns.fm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Authorized {
	@Id
	int id;
	String name;
	@Column(name="complaint_type")
	String complaintType;
	long phone_no;
	String email;
	String password;
	public Authorized() {
		super();
	}
	public Authorized(int id, String name, String complaintType, long phone_no, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.complaintType = complaintType;
		this.phone_no = phone_no;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
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
		return "Authorized [id=" + id + ", name=" + name + ", complaintType=" + complaintType + ", phone_no=" + phone_no
				+ ", email=" + email + ", password=" + password + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getComplaintType()=" + getComplaintType() + ", getPhone_no()=" + getPhone_no() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
