package com.example.employeeservice.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeservice.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8083/", value = "DEPARTMENT-SERVICE")
//@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
	@GetMapping("api/department/getbycode/{deptcode}")
	DepartmentDto getDepartmentBydeptCode(@PathVariable("deptcode") String deptcode);

}
