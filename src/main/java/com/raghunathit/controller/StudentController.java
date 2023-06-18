package com.raghunathit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.raghunathit.binding.Student;
import com.raghunathit.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		forminitBinding(model);
		
		return "index";
	}
	//@InitBinder
	private void forminitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses",service.getCourses());
		model.addAttribute("prefTimings", service.getTimings());
	}
	@PostMapping("/save")
	public String saveStudent(Student s,Model model) {
		boolean isSaved = service.saveStudent(s);
		if(isSaved) {
			model.addAttribute("msg", "Data Saved...");
		}
		
	forminitBinding(model);
		
		return "index";
	
	
}
}
