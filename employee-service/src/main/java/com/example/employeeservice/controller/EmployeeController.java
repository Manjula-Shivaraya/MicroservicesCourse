package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.exceptionHandling.ResourceNotFoundException;
import com.example.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedDepartmentDto = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
	}

	@GetMapping("/getbyId/{id}")
	public ResponseEntity<APIResponseDto> getDepartmentBydeptCode(@PathVariable("id") Long id) throws ResourceNotFoundException{
//		System.out.println("Came here");
		APIResponseDto empDto = employeeService.getEmpById(id);
		return new ResponseEntity<>(empDto ,HttpStatus.OK);
	}
}
