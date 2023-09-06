package com.example.kunal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kunal.DTO.EmployeeModel;
import com.example.kunal.Entity.Employee;
import com.example.kunal.Exception.EmployeeNotFoundException;
import com.example.kunal.Mapper.EmployeeMapper;
import com.example.kunal.Repository.EmployeeRepository;
import com.example.kunal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeModel getEmployeeById(Integer id) {
		Employee existData=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not exist with id"+id));
		EmployeeModel employeeModel=EmployeeMapper.MAPPER.getEmployeeModel(existData);
		return employeeModel;
	}

	@Override
	public List<EmployeeModel> getEmployeeList() {
		List<Employee> employeeList=employeeRepository.findAll();
		List<EmployeeModel> resultList=EmployeeMapper.MAPPER.getAllEmployeesModel(employeeList);
		return resultList;
	}


	@Override
	public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
		Employee emplEntity=EmployeeMapper.MAPPER.getEmployeeEntity(employeeModel);
		Employee saveEmployee=employeeRepository.saveAndFlush(emplEntity);
		EmployeeModel response=EmployeeMapper.MAPPER.getEmployeeModel(saveEmployee);
		return response;
	}

	@Override
	public EmployeeModel updateEmployee(Integer id, EmployeeModel employee) {
		Employee existData=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not exist with id"+id));
		employee.setEid(existData.getEid());
		existData=EmployeeMapper.MAPPER.getEmployeeEntity(employee);
		existData=employeeRepository.saveAndFlush(existData);
		EmployeeModel response=EmployeeMapper.MAPPER.getEmployeeModel(existData);
		return response;
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee existData=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not exist with id"+id));
		if(existData!=null) {
		employeeRepository.deleteById(id);
		}
		
	}

}
