package com.example.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.employeeservice.dto.APIResponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exceptionHandling.ResourceNotFoundException;
import com.example.employeeservice.repository.EmployeeRepo;
import com.example.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

	@Autowired
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee emp = modelMapper.map(employeeDto, Employee.class);
//		Employee emp = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
//				employeeDto.getEmail());
		Employee savedemp = employeeRepo.save(emp);
		EmployeeDto empDto = modelMapper.map(savedemp, EmployeeDto.class);
//		EmployeeDto empDto = new EmployeeDto(savedemp.getId(), savedemp.getFirstName(), savedemp.getLastName(),
//				savedemp.getEmail());
		return empDto;
	}

	@Override
	public APIResponseDto getEmpById(Long id) throws ResourceNotFoundException {
		Employee emp = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id: " + id + " is not present"));

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8083/api/department/getbycode/" + emp.getDeptCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();

//		DepartmentDto departmentDto = webClient.get()
//				.uri("http://localhost:8083/api/department/getbycode/" + emp.getDeptCode()).retrieve()
//				.bodyToMono(DepartmentDto.class).block();

		DepartmentDto departmentDto = apiClient.getDepartmentBydeptCode(emp.getDeptCode());

		EmployeeDto empDto = modelMapper.map(emp, EmployeeDto.class);
//		EmployeeDto empdto = new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail());

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(empDto);

		return apiResponseDto;
	}
}
