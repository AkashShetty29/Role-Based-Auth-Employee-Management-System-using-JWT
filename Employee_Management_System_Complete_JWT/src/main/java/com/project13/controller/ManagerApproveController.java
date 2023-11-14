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

import com.project13.doa.ManagerApproveReqRepo;
import com.project13.entity.ManagerApprovedReq;
import com.project13.entity.ManagerPendingRequest;
import com.project9.exception.ResourceNotFoundException;

@RestController
public class ManagerApproveController {
	
	@Autowired
	private ManagerApproveReqRepo managerApproveRequestRepo;
	
	@PostMapping("/managerApproveRequest")
	public ManagerApprovedReq managerApproveRequestsFunc(@RequestBody ManagerApprovedReq ApprovedReqHR)
	{
		return managerApproveRequestRepo.save(ApprovedReqHR);
		
	}
	
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/managerApproveRequest")
	public List<ManagerApprovedReq> getAllmanagerApproveRequest()
	{
		return managerApproveRequestRepo.findAll();
	}
	
	
	@GetMapping("/managerApproveRequest/{reqId}")
	public ResponseEntity<ManagerApprovedReq> getManagerApproveById(@PathVariable Integer reqId)
	{
		ManagerApprovedReq managerApproveReq = managerApproveRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(managerApproveReq);
	}
	
	
	
	@DeleteMapping("/managerApproveRequest/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		ManagerApprovedReq request = managerApproveRequestRepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		managerApproveRequestRepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
