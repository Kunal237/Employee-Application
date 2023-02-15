package com.example.kunal.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.kunal.DTO.EmployeeModel;
import com.example.kunal.Entity.Employee;

@Mapper
public interface EmployeeMapper{
	
	EmployeeMapper MAPPER=Mappers.getMapper(EmployeeMapper.class);
	
	public List<EmployeeModel> getAllEmployeesModel(List<Employee> employees);

	public List<Employee> getAllEmployeesEntity(List<EmployeeModel>employeesModel);
	
	public EmployeeModel getEmployeeModel(Employee employees);
	
	public Employee getEmployeeEntity(EmployeeModel employeesModel);
	
	
	
	
}
