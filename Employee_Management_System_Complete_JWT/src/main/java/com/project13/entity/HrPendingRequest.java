package com.project13.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HrPendingRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reqId;
	

	private String empName;
	

	private String email;
	
	
	private String phone;


	private String manager;
	

	private String teamLead;
	

	private String department;
	

	private String designation;
	

	private String role;
	
	
	private String deletion;


	public HrPendingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HrPendingRequest(int reqId, String empName, String email, String phone, String manager, String teamLead,
			String department, String designation, String role, String deletion) {
		super();
		this.reqId = reqId;
		this.empName = empName;
		this.email = email;
		this.phone = phone;
		this.manager = manager;
		this.teamLead = teamLead;
		this.department = department;
		this.designation = designation;
		this.role = role;
		this.deletion = deletion;
	}


	public HrPendingRequest(String empName, String email, String phone, String manager, String teamLead,
			String department, String designation, String role, String deletion) {
		super();
		this.empName = empName;
		this.email = email;
		this.phone = phone;
		this.manager = manager;
		this.teamLead = teamLead;
		this.department = department;
		this.designation = designation;
		this.role = role;
		this.deletion = deletion;
	}


	public int getReqId() {
		return reqId;
	}


	public void setReqId(int reqId) {
		this.reqId = reqId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getTeamLead() {
		return teamLead;
	}


	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getDeletion() {
		return deletion;
	}


	public void setDeletion(String deletion) {
		this.deletion = deletion;
	}


	@Override
	public String toString() {
		return "HrPendingRequest [reqId=" + reqId + ", empName=" + empName + ", email=" + email + ", phone=" + phone
				+ ", manager=" + manager + ", teamLead=" + teamLead + ", department=" + department + ", designation="
				+ designation + ", role=" + role + ", deletion=" + deletion + "]";
	}


	
	

}
