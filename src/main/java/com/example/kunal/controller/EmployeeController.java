package com.example.kunal.controller;



import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kunal.DTO.EmployeeModel;
import com.example.kunal.service.EmployeeService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	
	 org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<EmployeeModel>  saveEmployee(@Valid @RequestBody EmployeeModel employee ){
		EmployeeModel result=employeeService.saveEmployee(employee);
		return new ResponseEntity<EmployeeModel>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllEmloyees")
	public ResponseEntity<List<EmployeeModel>> getAllEmloyees(){
		List<EmployeeModel> employees=employeeService.getEmployeeList();
		return new ResponseEntity<List<EmployeeModel>>(employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmloyeeById/{id}")
	public ResponseEntity<EmployeeModel> getEmloyeeById(@PathVariable("id") Integer id){
		EmployeeModel employee=employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeModel>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeModel> updateEmployeeById(@PathVariable("id") Integer id, @RequestBody EmployeeModel updateEmployee){
		EmployeeModel response=employeeService.updateEmployee(id,updateEmployee);
		return new ResponseEntity<EmployeeModel> (response,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Integer id) {
		logger.info("delete employee"+id);
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
