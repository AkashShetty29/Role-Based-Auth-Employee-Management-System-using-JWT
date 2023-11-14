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

import com.project13.doa.HrPendingRequestRepo;
import com.project13.entity.HrPendingRequest;
import com.project13.entity.ManagerApprovedReq;
import com.project9.exception.ResourceNotFoundException;

@RestController
public class HrPendingRequestsController {
	
	@Autowired
	private HrPendingRequestRepo hrPendingRequestRepo;
	

	
	@PostMapping("/hrPendingRequest")
	public HrPendingRequest hrPendingRequestsFunc(@RequestBody HrPendingRequest pendingReq)
	{
		return hrPendingRequestRepo.save(pendingReq);
	}
	
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/hrPendingRequest")
	public List<HrPendingRequest> getAllHRPendingRequest()
	{
		return hrPendingRequestRepo.findAll();
	}
	
	
	@GetMapping("/hrPendingRequest/{reqId}")
	public ResponseEntity<HrPendingRequest> getHRPendingById(@PathVariable Integer reqId)
	{
		HrPendingRequest hrPendingReq = hrPendingRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(hrPendingReq);
	}
	
	
	@DeleteMapping("/hrPendingRequest/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		HrPendingRequest request = hrPendingRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		hrPendingRequestRepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
