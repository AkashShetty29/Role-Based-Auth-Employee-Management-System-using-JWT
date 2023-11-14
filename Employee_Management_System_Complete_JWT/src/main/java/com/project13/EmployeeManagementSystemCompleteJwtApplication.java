package com.project13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.project13.entity")
public class EmployeeManagementSystemCompleteJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemCompleteJwtApplication.class, args);
	}

}

