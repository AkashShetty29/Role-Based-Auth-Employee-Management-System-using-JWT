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

import com.project13.doa.HrApproveRequestRepo;
import com.project13.entity.HrApproveRequest;
import com.project13.entity.HrPendingRequest;
import com.project9.exception.ResourceNotFoundException;

@RestController
public class HrApproveRequestsController {
	
	@Autowired
	private HrApproveRequestRepo hrApproveRequestrepo;
	
	
	@PostMapping("/hrApproveRequest")
	public HrApproveRequest hrApproveRequestsFunc(@RequestBody HrApproveRequest approveReq)
	{
		return hrApproveRequestrepo.save(approveReq);
	}
	
	
	//TO SHOW ALL EMPLOYEE DETAILS IN THE DATABASE
	
	@GetMapping("/hrApproveRequest")
	public List<HrApproveRequest> getAllHRApproveRequest()
	{
		return hrApproveRequestrepo.findAll();
	}
	
	
	@GetMapping("/hrApproveRequest/{reqId}")
	public ResponseEntity<HrApproveRequest> getHRApproveById(@PathVariable Integer reqId)
	{
		HrApproveRequest hrApproveReq = hrApproveRequestrepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not existed with a given id "+reqId));
		
		return ResponseEntity.ok(hrApproveReq);
	}
	
	@DeleteMapping("/hrApproveRequest/{reqId}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Integer reqId)
	{
		HrApproveRequest request = hrApproveRequestrepo.findById(reqId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id "+reqId));
		
		hrApproveRequestrepo.delete(request);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
