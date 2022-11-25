package com.gridscape.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gridscape.entity.Employee;
import com.gridscape.repository.EmployeeRepository;

public class CustomEmployeeservice implements UserDetailsService{

	@Autowired
	private EmployeeRepository emprepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		  //Employee user = emprepo.findByEmail(email);
		Employee user=emprepo.findByEmail(email);
		  
		  System.out.println(user);
		  System.out.println();
		  
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustomEmployee(user);
		
	
	}
	

}
