package com.example.employeeservice.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	private Long deptId;
	private String deptName;
	private String deptDesc;
	private String deptCode;
}