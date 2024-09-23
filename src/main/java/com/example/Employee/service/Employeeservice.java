package com.example.Employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.MinorException;
import com.example.Employee.Exception.NameNotFoundException;
import com.example.Employee.dao.Employeedao;
import com.example.Employee.entity.Employeeentity;

@Service
public class Employeeservice {
@Autowired
Employeedao ed;
public String postthis(Employeeentity e) {
	return ed.postthis(e);
}
public List<Employeeentity> getthis() {
	return ed.getthis();
}
public Employeeentity getvalue(int a) {
	return ed.getvalue(a);
}
public String putthis(Employeeentity a) {
	return ed.putmethod(a);
}
public String deletethis(Employeeentity b) {
	return ed.deletethis(b);

}
public List<Employeeentity> getsalary() {
	List<Employeeentity>emp=ed.getthis();
	List<Employeeentity>salaries=emp.stream().filter(X->X.getSalary()>40000).collect(Collectors.toList());
	return salaries;
}
public List<Employeeentity> getsalary1() {
	List<Employeeentity>emp1=ed.getthis();
	List<Employeeentity>secmaxxi=emp1.stream().sorted(Comparator.comparingInt(Employeeentity::getSalary).reversed()).limit(2).skip(1).collect(Collectors.toList());
	return secmaxxi;
}

public List<Employeeentity> getsalary(int salary) {
	return ed.getsalary(salary);
}

public List<Employeeentity> getsalaries() {
	return ed.getsalaries();
}

public List<Object> getsalary11() {
	return ed.getsalary11();
	
}

public List<Object> getsalary12() {
	return ed.getsalary12();
}

public List<Object> getsalary13() {
	return ed.getsalary13();
}

//JPA QUERY

public List<Employeeentity>getssalary(int a) {
	return ed.getssalary(a);
}

//NameNotFoundException
public String getName(int id) throws NameNotFoundException {
	if(ed.getName(id).startsWith("s")) {
		return ed.getName(id);
	}
	else {
		throw new NameNotFoundException("name not found");
	}
}

//EmptyException
public Employeeentity getbyName(String name) throws EmptyException {
if(ed.getbyName(name).isEmpty()) {
	throw new EmptyException("not found");
}
else {
	return ed.getbyName(name).get();
}
}

//MinorException
public String Postexception(Employeeentity q) throws MinorException {
	if(q.getAge()>18) {
		return ed.Postexception(q);
	}
	else {
         throw new MinorException("Is not eligible");
	}
}
//Patchmapping
public String Patch(Employeeentity e, int id) {
	return ed.Patch(e,id);
}
public String deleteone(int a) {
	return ed.deleteone(a);

}

}
