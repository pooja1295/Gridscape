package com.gridscape.repository;

import org.springframework.data.repository.CrudRepository;

import com.gridscape.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
	
}
