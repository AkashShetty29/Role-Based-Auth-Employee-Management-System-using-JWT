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

import com.project13.doa.AdminPendingRequestsRepo;

import com.project13.entity.AdminPendingRequests;
import com.project13.entity.HrApproveRequest;
import com.project9.exception.ResourceNotFoundException;

@RestController
public class AdminPendingRequestsController {
	
	@Autowired
	private AdminPendingRequestsRepo adminPendingRequestsRepo;
	
	
	@PostMapping("/updateRequestToAdmin")
	public AdminPendingRequests updateRequests(@RequestBody AdminPendingRequests requests)
	{
		return adminPendingRequestsRepo.save(requests);
	}
	

	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/updateRequestToAdmin")
	public List<AdminPendingRequests> getAllAdminPendingRequest()
	{
		return adminPendingRequestsRepo.findAll();
	}
	
	
	@GetMapping("/updateRequestToAdmin/{reqId}")
	public ResponseEntity<AdminPendingRequests> getAdminPendingById(@PathVariable Integer reqId)
	{
		AdminPendingRequests adminPendingReq = adminPendingRequestsRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(adminPendingReq);
	}
	
	@DeleteMapping("/updateRequestToAdmin/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		AdminPendingRequests request = adminPendingRequestsRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		adminPendingRequestsRepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
