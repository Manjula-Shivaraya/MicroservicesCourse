package com.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class APIResponseDto {
	
	private EmployeeDto employee;
	private DepartmentDto department;
}
