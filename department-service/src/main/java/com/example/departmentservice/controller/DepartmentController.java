package com.example.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.service.DepartmentService;

@RequestMapping("/api/department")
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save")
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/getbycode/{deptcode}")
	public ResponseEntity<DepartmentDto> getDepartmentBydeptCode(@PathVariable("deptcode") String deptcode){
		DepartmentDto departmentDto = departmentService.getDepartmentBydeptCode(deptcode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
}
