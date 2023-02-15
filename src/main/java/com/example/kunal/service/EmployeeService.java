package com.example.kunal.service;

import java.util.List;

import com.example.kunal.DTO.EmployeeModel;

public interface EmployeeService {
	
	public List<EmployeeModel> getEmployeeList();
	
	public EmployeeModel getEmployeeById(Integer id);
	
	public EmployeeModel saveEmployee(EmployeeModel employee);
	
	public EmployeeModel updateEmployee(Integer id,EmployeeModel employee);
	
	public void deleteEmployee(Integer id);

}
