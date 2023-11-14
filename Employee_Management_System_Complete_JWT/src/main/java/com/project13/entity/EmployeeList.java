package com.project13.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EmployeeList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	

	
	private String empName;
	

	private String email;
	
	private String phone;

	private String manager;
	

	private String teamLead;
	

	private String department;
	

	private String designation;
	
//    @ManyToOne
//    @JoinColumn(name = "role_name")
	private String role;
    
//  @ManyToOne
//  @JoinColumn(name = "role_name")
//  private Role emprole;

	public EmployeeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeList(int empId, String empName, String email, String phone, String manager, String teamLead,
			String department, String designation, String role) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.phone = phone;
		this.manager = manager;
		this.teamLead = teamLead;
		this.department = department;
		this.designation = designation;
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	@Override
	public String toString() {
		return "EmployeeList [empId=" + empId + ", empName=" + empName + ", email=" + email + ", phone=" + phone
				+ ", manager=" + manager + ", teamLead=" + teamLead + ", department=" + department + ", designation="
				+ designation + ", role=" + role + "]";
	}
    


	
    


}
