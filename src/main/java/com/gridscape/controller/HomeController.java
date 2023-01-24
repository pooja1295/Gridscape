package com.gridscape.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.gridscape.entity.Department;
import com.gridscape.entity.Employee;
import com.gridscape.repository.DepartmentRepository;
import com.gridscape.repository.EmployeeRepository;


@Controller
@RequestMapping("/user")
public class HomeController {
	
	@Autowired
     private EmployeeRepository emprepo;
	
	@Autowired
	private DepartmentRepository drepo;
	
	//home controller after login form
	@GetMapping("/home")
	public String home(Principal p,Model m) 
	{
		String em=p.getName();
		Employee emp=emprepo.findByEmail(em);

		m.addAttribute("fullname",emp.getName() );
		m.addAttribute("address",emp.getAddress());
		m.addAttribute("email", emp.getEmail());
		m.addAttribute("profession", emp.getProfession());
		m.addAttribute("city", emp.getCity());
		m.addAttribute("State", emp.getState());
		m.addAttribute("id", emp.getId());
		m.addAttribute("mno", emp.getMno());
		m.addAttribute("dob", emp.getDob());
		m.addAttribute("imgs",emp.getImg());
		//System.out.println(emp.getImg());
		m.addAttribute("emp", emp);
		
		return "home";
	}

	//update controller by id
	@PostMapping("/update/{id}")
	public String updatedetail(@PathVariable("id")Integer id,Model m,Principal p) 
	{
		m.addAttribute("title", "Update Employee");
		Employee emp1 = this.emprepo.findById(id).get();
		m.addAttribute("emp", emp1);
		System.out.println(emp1);
		System.out.println("hello");
		return "updateemp";
	}
	
	
	    // update Employee handler
		@PostMapping("/updatedetail")
		public String updateHandler(@ModelAttribute Employee emp ,@RequestParam("profileImage") MultipartFile file,@RequestParam("department_id") int did,HttpSession session) throws IOException {
			
			/*
			 * System.out.println(emp); System.out.println(did);
			 */
			Employee olddetail=this.emprepo.findById(emp.getId());
			
			  if(!file.isEmpty()) 
			  { 
              File saveFile=new ClassPathResource("static/img").getFile();
			  
			  Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			  
			  Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			  
			  emp.setImg(file.getOriginalFilename());
			  System.out.println("Imgae uploaded"); 
			  
			  }
			  else {
				  //upload file to folder 
				  emp.setImg(olddetail.getImg());
			  
			  
			  }
			  
			  //for get department
			  Department drecored=drepo.findById(did).get();
			  emp.setDepartment(drecored);
			  emp.setRole("ROLE_USER");
			  emprepo.save(emp);
		      return "back";
		      }

}
