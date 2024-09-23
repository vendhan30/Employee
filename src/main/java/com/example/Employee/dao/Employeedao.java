package com.example.Employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Employee.entity.Employeeentity;
import com.example.Employee.repository.Employeerepository;

@Repository
public class Employeedao {
@Autowired
Employeerepository er;
public String postthis(Employeeentity e ) {
	er.save(e);
	return "Posted Successfully";
}
public List<Employeeentity> getthis() {
	return er.findAll();

}
public Employeeentity getvalue(int a) {
return er.findById(a).get();
}
public String putmethod(Employeeentity a) {
	er.save(a);
	return "updated succesfully";
}
public String deletethis(Employeeentity b) {
	er.delete(b);
	return "deleted successfully";
}
//NATIVE QUERY
public List<Employeeentity> getsalary(int salary) {
	return er.getsalary(salary);
}

public List<Employeeentity> getsalaries() {
	return er.getsalaries();
}

public List<Object> getsalary11() {
	return er.getsalary11();
	}

public List<Object> getsalary12() {
	return er.getsalary12();
}

public List<Object> getsalary13() {
	return er.getsalary13();
}
//
//public List<Employeeentity> getsalaryrange(int a, int b) {
//	return er.getsalaryrange(a,b);

//JPA QUERY
public List<Employeeentity>getssalary(int a) {
	return er.getssalary(a);
}

//NameNotFoundException

public String getName(int id) {
	return er.findById(id).get().getName();
}

//EmptyException
public Optional<Employeeentity> getbyName(String name) {
	return er.getbyName(name);
}

//MinorException
public String Postexception(Employeeentity q) {
	er.save(q);
	return "yes posted";
	
}

//Patchmapping
//public String Patch(Employeeentity e, int id) {
//          Employeeentity X=er.findById(id).get();
//          X.setAge(e.getAge());
//          er.save(X);
//		return "Updated Sucessfully";
//          
//}

public String Patch(Employeeentity e, int id) {
	er.save(e);
	return "Updated Sucesfully";
}
public String deleteone(int a) {
	er.deleteById(a);
	return "Deleted Sucessfully";

}


}
