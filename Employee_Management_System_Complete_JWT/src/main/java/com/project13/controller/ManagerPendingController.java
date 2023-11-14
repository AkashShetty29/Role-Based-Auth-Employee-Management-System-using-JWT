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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project13.doa.ManagerPendingReqRepo;
import com.project13.doa.UserDao;
import com.project13.entity.EmployeeList;
import com.project13.entity.HrPendingRequest;
import com.project13.entity.ManagerPendingRequest;
import com.project9.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ManagerPendingController {
	
	@Autowired
	private ManagerPendingReqRepo managerPendingRequestRepo;
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/managerPendingRequest")
	public ManagerPendingRequest managerPendingRequestsFunc(@RequestBody ManagerPendingRequest pendingReqHR)
	{
		return managerPendingRequestRepo.save(pendingReqHR);
		
	}
	
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
//	@GetMapping("/managerPendingRequest")
//	public List<ManagerPendingRequest> getAllmanagerPendingRequest()
//	{
//		return managerPendingRequestRepo.findAll();
//	}
	
	@GetMapping("/managerPendingRequest")
	public List<ManagerPendingRequest> getManagersPendingRequest()
	{
		return managerPendingRequestRepo.findAll();
	}
	
	
	@GetMapping("/managerPendingRequest/{reqId}")
	public ResponseEntity<ManagerPendingRequest> getManagerPendingById(@PathVariable Integer reqId)
	{
		ManagerPendingRequest managerPendingReq = managerPendingRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(managerPendingReq);
	}
	
	
	
	@DeleteMapping("/managerPendingRequest/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		ManagerPendingRequest request = managerPendingRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		managerPendingRequestRepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
