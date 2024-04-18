package com.tns.fm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Academic {
	@Id
	int id;
	String name;
	@Column(name="email")
	String email;
	long mobile;
	String department;
	@Column(name="complaint_type")
	String complaintType;
	String complaint;
	String status;
	String date;
	public Academic() {
		super();
	}
	public Academic(int id, String name, String email, long mobile, String department, String complaintType,
			String complaint, String status, String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.department = department;
		this.complaintType = complaintType;
		this.complaint = complaint;
		this.status = status;
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
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Academic [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", department="
				+ department + ", complaintType=" + complaintType + ", complaint=" + complaint + ", status=" + status
				+ ", date=" + date + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getMobile()=" + getMobile() + ", getDepartment()=" + getDepartment() + ", getComplaintType()="
				+ getComplaintType() + ", getComplaint()=" + getComplaint() + ", getStatus()=" + getStatus()
				+ ", getDate()=" + getDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}