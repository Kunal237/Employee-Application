package com.example.kunal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kunal.Entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer > {
	
	public List<Employee> findAll();
	
	@Query(value="from Employee e where e.eid = :id")
	public Employee  findEmployeeById(@Param("id") Integer id);

}
