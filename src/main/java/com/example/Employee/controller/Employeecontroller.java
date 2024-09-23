package com.example.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.MinorException;
import com.example.Employee.Exception.NameNotFoundException;
import com.example.Employee.entity.Employeeentity; 
import com.example.Employee.service.Employeeservice;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("*")
public class Employeecontroller {

	@Autowired
	Employeeservice es;
	@PostMapping(value="/postemp")
	public String postthis(@RequestBody Employeeentity e) {
		return es.postthis(e);
			}
	
		@GetMapping(value="/getemp")
	public List<Employeeentity> getthis() {
		return es.getthis();
		}
		
		@GetMapping(value="/getid/{a}")
		public Employeeentity getvalue(@PathVariable int a) {
			return es.getvalue(a);
		}
		
	@PutMapping(value="/putemp")
	public String putthis(@RequestBody Employeeentity a) {		
		return es.putthis(a);
	}
	
	@DeleteMapping(value="/deleteemp")
	public String deletethis(@RequestBody Employeeentity b) {
		return es.deletethis(b);	
	}	
	
	@DeleteMapping(value="/delete/{a}")
	public String deleteone(@PathVariable int a) {
		return es.deleteone(a);
	}
	
	@GetMapping(value="/getsalary")	
	public List<Employeeentity> getsalary() {
		return es.getsalary();
	
	}
	
	@GetMapping(value="/getsalaryy")	
	public List<Employeeentity> getsalary1() {
		return es.getsalary1();
		
	}
	
	@GetMapping(value="/getsalary/{a}")
	public List<Employeeentity> getsalary(@PathVariable int a) {
		return es.getsalary(a);
	}
	
	@GetMapping(value="/getmaxsalary")
	public List<Employeeentity> getsalaries() {
		return es.getsalaries();
	}
	
	@GetMapping(value="/getsalariesyes")
	public List<Object> getsalary11() {
		return es.getsalary11();
		
	}
	@GetMapping(value="/getstartswith")
	public List<Object>getsalary12() {
		return es.getsalary12();
	}
	
	@GetMapping(value="/getsalary<35000")
	public List<Object> getsalary13() {
		return es.getsalary13();
	}
	
//JPA QUERY
    @GetMapping(value="/getssalaryy/{a}")
	public List<Employeeentity>getssalary(@PathVariable int a) {
		return es.getssalary(a);
	}
    
    
 //NameNotFoundException
    
    @GetMapping(value="/getName/{id}")
    public String getName(@PathVariable int id) {
    	try {
    	return es.getName(id);
    	}
    	catch(NameNotFoundException ne) {
    	return "no name found";
}
}
//EmptyException 
    
    @GetMapping(value="/getbyName/{name}")
    public Employeeentity getbyName(@PathVariable String name) throws EmptyException {
    	return es.getbyName(name);
    }
    
//MinorException
    @PutMapping(value="/postExe")
    public String Postexception(@RequestBody Employeeentity a) throws MinorException {
    return es.Postexception(a);
    }
    
//PatchMapping 
  @PutMapping(value="/PatchEmp/{id}")
  public String Patch(@RequestBody Employeeentity e, @PathVariable int id) {
	return es.Patch(e,id);
   
}
}