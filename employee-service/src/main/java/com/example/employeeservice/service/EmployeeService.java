package com.example.employeeservice.service;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.exceptionHandling.ResourceNotFoundException;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto employeeDto);

	public APIResponseDto getEmpById(Long id) throws ResourceNotFoundException;

}
