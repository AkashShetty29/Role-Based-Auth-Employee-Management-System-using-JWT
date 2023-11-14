package com.project13.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project13.doa.AdminApprovedRequestsRepo;
import com.project13.entity.AdminApprovedRequests;
import com.project13.entity.AdminPendingRequests;
import com.project9.exception.ResourceNotFoundException;





@RestController
public class AdminApprovedRequestsController {
	
	@Autowired
	private AdminApprovedRequestsRepo adminApprovedRequestsRepo;
	
	
	@PostMapping("/approvedRequestByAdmin")
	public AdminApprovedRequests approvedRequest(@RequestBody AdminApprovedRequests requests)
	{
		return adminApprovedRequestsRepo.save(requests);
	}
	
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/approvedRequestByAdmin")
	public List<AdminApprovedRequests> getAllAdminApprovedRequest()
	{
		return adminApprovedRequestsRepo.findAll();
	}
	
	
	@GetMapping("/approvedRequestByAdmin/{reqId}")
	public ResponseEntity<AdminApprovedRequests> getAdminApprovedRequestById(@PathVariable Integer reqId)
	{
		AdminApprovedRequests adminApprovedReq = adminApprovedRequestsRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(adminApprovedReq);
	}
	
	
	
	@DeleteMapping("/approvedRequestByAdmin/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		AdminApprovedRequests request = adminApprovedRequestsRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		adminApprovedRequestsRepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}





}
