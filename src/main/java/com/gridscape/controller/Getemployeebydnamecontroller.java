package com.gridscape.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gridscape.entity.Employee;
import com.gridscape.repository.EmployeeRepository;

@RestController

public class Getemployeebydnamecontroller {
	
	
	@Autowired
	private EmployeeRepository emprepo;
	
	
	
	//API for Get employee by department Name
	@GetMapping("/employee/{dname}")
	public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable("dname") String name)
	{
		return new ResponseEntity<List<Employee>>(emprepo.getEmployeeByDepName(name), HttpStatus.OK);
	}

}
