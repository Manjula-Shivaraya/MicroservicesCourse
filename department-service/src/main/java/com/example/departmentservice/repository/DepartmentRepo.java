package com.example.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

	
	public Department findByDeptCode(String deptcode);

}
