package com.gridscape.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gridscape.entity.Employee;
import com.gridscape.repository.EmployeeRepository;


@Controller
public class Empcontroller {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private BCryptPasswordEncoder bp;
	
	
	@GetMapping("/")
	public String home() 
	{
		
		return "index";
	}
	
	//Get registration form

	@GetMapping("/rejquery")
	public String reg() 
	{
		
		return "regjquery";
	}
	
	
	//Registration processing form
	@PostMapping("/register")
	public String register(@ModelAttribute Employee emp ,Model model,@RequestParam("profileImage") MultipartFile file,HttpSession session) throws Exception 
	{
		//Let's check if user already registered with us
        if(checkIfUserExist(emp.getEmail()))
        {
        	model.addAttribute("emp", emp);
			session.setAttribute("message", "User Already Exit !! ");
        	return "regjquery";
        }
        
        
	
		if(file.isEmpty())
		{
			System.out.println("File is empty");
			System.out.println("File is empty");
		}
		else 
		{
			//upload file to folder
			emp.setImg(file.getOriginalFilename());
			
			File saveFile=new ClassPathResource("static/img").getFile();
			
			Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			//System.out.println("Imgae uploaded");
		}
		
		
		//System.out.println(emp);
		emp.setPassword(bp.encode(emp.getPassword()));
		emp.setRole("ROLE_USER");
		emprepo.save(emp);
		session.setAttribute("message", "User successfully register");
		return "login";
		
	}
	
	//check Email exit or not 
	public boolean checkIfUserExist(String email) {
        return emprepo.findByEmail(email) !=null ? true : false;
    }
	
	
	//signin form
	@GetMapping("/signin")
	public String login() 
	{
		
		return "login";
	}
	
	
}
