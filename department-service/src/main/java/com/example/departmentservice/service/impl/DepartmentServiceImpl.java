package com.example.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepo;
import com.example.departmentservice.service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department dept = new Department(departmentDto.getDeptId(), departmentDto.getDeptName(),
				departmentDto.getDeptDesc(), departmentDto.getDeptCode());
		Department savedDept = departmentRepo.save(dept);
		DepartmentDto deptDto = new DepartmentDto(savedDept.getDeptId(), departmentDto.getDeptName(),
				savedDept.getDeptDesc(), savedDept.getDeptCode());
		return deptDto;
	}

	@Override
	public DepartmentDto getDepartmentBydeptCode(String deptcode) {		
		Department department =  departmentRepo.findByDeptCode(deptcode);
		DepartmentDto deptDto = new DepartmentDto(department.getDeptId(), department.getDeptName(),
				department.getDeptDesc(), department.getDeptCode());
		return deptDto;
	}

}
