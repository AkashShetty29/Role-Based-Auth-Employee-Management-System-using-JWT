package com.project13.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Role {


	@Id
    private String roleName;
    private String roleDescription;
    
    
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}
    
    
    
    
    
//	public String getRoleName() {
//		return roleName;
//	}
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//	public String getRoleDescription() {
//		return roleDescription;
//	}
//	public void setRoleDescription(String roleDescription) {
//		this.roleDescription = roleDescription;
//	}
    
    
    
//    @OneToMany(mappedBy = "emprole")
//   private List<EmployeeList> employee;

    
    
}
