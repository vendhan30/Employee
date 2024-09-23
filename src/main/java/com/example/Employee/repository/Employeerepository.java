package com.example.Employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Employee.entity.Employeeentity;

public interface Employeerepository extends JpaRepository<Employeeentity,Integer> {

	@Query(value="select * from employee_db where salary > ?",nativeQuery=true)
	
	public List<Employeeentity> getsalary(int salary);
	
	@Query(value="select * from employee_db where salary =(select max(salary)from employee_db)", nativeQuery=true)
	
	public List<Employeeentity> getsalaries();
	
	@Query(value="select name, salary from employee_db  where salary>25000 and gender like 'female'", nativeQuery=true)
	
	public List<Object> getsalary11();
	
	@Query(value="select name from employee_db where name like 'v%'" ,nativeQuery=true)
	
	public List<Object> getsalary12();
	
	@Query(value="select name, role from employee_db where salary>35000", nativeQuery=true)

	public List<Object> getsalary13();
	
//	@Query(value="select * from employee_db where salary>? and salary<?",nativeQuery=true)
//	public List<Employeeentity> getsalaryrange(int a, int b);

//JPA QUERY
	
	@Query(value="select a from Employeeentity a where a.salary>:salary")
	public List<Employeeentity> getssalary(@Param("salary") int salary);
	
//	@Query(value="select a.salary, a.age from Employeeentity a where a.age>:age")
//	public List<Employeeentity> getssalary1(@Param ("age") int e);
	
//EmptyException
	@Query(value="select * from employee_db where name like ?" ,nativeQuery=true)
	public Optional<Employeeentity> getbyName(String name);


	
}

