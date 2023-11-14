package com.project13.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.project13.doa.EmployeeListRepo;
import com.project13.entity.User;
import com.project13.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

	
//	@Autowired
//	private EmployeeListRepo employeeListRepo;
    
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }
    
    @GetMapping({"/forManager"})
    @PreAuthorize("hasRole('Manager')")
    public String forManager(){
        return "This URL is only accessible to the Manager";
    }
    
    @GetMapping({"/forHR"})
    @PreAuthorize("hasRole('HR')")
    public String forHR(){
        return "This URL is only accessible to the HR";
    }
    
    @GetMapping({"/forTeamLead"})
    @PreAuthorize("hasRole('TeamLead')")
    public String forTeamLead(){
        return "This URL is only accessible to the Team Lead";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the User";
    }
    
//	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
//	
//	@GetMapping("/employees")
//	public List<EmployeeList> getAllEmployees()
//	{
//		return employeeListRepo.findAll();
//	}
}
