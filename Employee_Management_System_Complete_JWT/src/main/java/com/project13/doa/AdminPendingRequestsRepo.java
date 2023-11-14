package com.project13.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project13.entity.AdminPendingRequests;

public interface AdminPendingRequestsRepo extends JpaRepository<AdminPendingRequests, Integer> {

	

}
