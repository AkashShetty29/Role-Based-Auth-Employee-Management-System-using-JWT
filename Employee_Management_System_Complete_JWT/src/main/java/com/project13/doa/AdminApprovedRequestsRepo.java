package com.project13.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project13.entity.AdminApprovedRequests;

public interface AdminApprovedRequestsRepo extends JpaRepository<AdminApprovedRequests, Integer>{

}
