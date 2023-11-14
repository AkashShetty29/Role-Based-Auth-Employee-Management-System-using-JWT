package com.project13.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project13.doa.EmployeeListRepo;
import com.project13.doa.UserDao;
import com.project13.entity.EmployeeList;
import com.project9.exception.ResourceNotFoundException;




@RestController
//@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeListController {
	
	@Autowired
	private EmployeeListRepo employeeListRepo;
	
	@Autowired
	private UserDao userDao;
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/employees")
	public List<EmployeeList> getAllEmployees()
	{
		return employeeListRepo.findAll();
	}
	
	
	//TO CREATE NEW EMPLOYEE
	
	@PostMapping("/employees")
	public EmployeeList createEmployee(@RequestBody EmployeeList employee)
	{
		return employeeListRepo.save(employee);
	}
	
	
	//TO DISPLAY DATA BASED ON ID
	
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<EmployeeList> getEmployeesById(@PathVariable Integer empId)
	{
		EmployeeList employee = employeeListRepo.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+empId));
		
		return ResponseEntity.ok(employee);
	}
	
	
	//TO UPDATE EMPLOYEE DETAILS IN DATABASE
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<EmployeeList> updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeList oldDetails)
	{
		EmployeeList newDetails = employeeListRepo.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+empId));
		
		
		newDetails.setEmpName(oldDetails.getEmpName());
		newDetails.setEmail(oldDetails.getEmail());
		newDetails.setPhone(oldDetails.getPhone());
		newDetails.setRole(oldDetails.getRole());
		newDetails.setManager(oldDetails.getManager());
		newDetails.setTeamLead(oldDetails.getTeamLead());
		newDetails.setDepartment(oldDetails.getDepartment());
		newDetails.setDesignation(oldDetails.getDesignation());
		
		EmployeeList updatedDetsils = employeeListRepo.save(newDetails);
		return ResponseEntity.ok(updatedDetsils);
		
	}
	
	//TO DELETE EMPLOYEE BY ID
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer empId)
	{
		EmployeeList employee = employeeListRepo.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+empId));
		
		employeeListRepo.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
