package com.tns.fm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sensitive_comp {
	@Id
	int id;
	String name;
	@Column(name="email")
	String email;
	long mobile;
	String department;
	String complaint;
	String date;
	public Sensitive_comp() {
		super();
	}
	public Sensitive_comp(int id, String name, String email, long mobile, String department, String complaint,
			String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.department = department;
		this.complaint = complaint;
		this.date = date;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Sensitive_comp [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", department=" + department + ", complaint=" + complaint + ", date=" + date + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getMobile()=" + getMobile()
				+ ", getDepartment()=" + getDepartment() + ", getComplaint()=" + getComplaint() + ", getDate()="
				+ getDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
