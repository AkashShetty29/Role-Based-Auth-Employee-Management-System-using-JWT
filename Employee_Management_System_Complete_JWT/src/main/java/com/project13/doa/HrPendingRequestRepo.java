package com.project13.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project13.entity.HrPendingRequest;

public interface HrPendingRequestRepo extends JpaRepository<HrPendingRequest, Integer>{

}
