package com.project13.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project13.entity.EmployeeList;

@Repository
public interface EmployeeListRepo extends JpaRepository<EmployeeList, Integer> {

}
