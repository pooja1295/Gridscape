package com.gridscape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gridscape.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	 
	    public Employee findByEmail(String email);
	    public Employee findById(int id);
	    
	    
	    /*@Query("FROM employee WHERE department.d_name=:dname")
	    public List<Employee> getByDName(String dname);
	    */
		
		/*
		 * @Query("select e.name,e.email FROM employee e LEFT JOIN e.employees d")
		 * List<Employee> findbydname(@Param("d_name") String d_name);
		 */
	    @Query("FROM employee where department.d_name=:name")
	    public List<Employee> getEmployeeByDepName(String name);
	   
	    
	    
	    }
	    
	    
