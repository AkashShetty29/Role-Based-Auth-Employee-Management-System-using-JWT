package com.project13.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project13.entity.ManagerPendingRequest;

public interface ManagerPendingReqRepo extends JpaRepository<ManagerPendingRequest, Integer> {

}
