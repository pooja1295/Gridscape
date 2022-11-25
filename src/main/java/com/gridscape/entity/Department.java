package com.gridscape.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="department")
public class Department {
	
	
	@Id
	private int department_id;
	private String d_name;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees;
	
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Department(int department_id, String d_name, List<Employee> employees) {
		super();
		this.department_id = department_id;
		this.d_name = d_name;
		this.employees = employees;
	}



	public int getDepartment_id() {
		return department_id;
	}



	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}



	public String getD_name() {
		return d_name;
	}



	public void setD_name(String d_name) {
		this.d_name = d_name;
	}



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	


	
	
	
	
	
	
	

}
