package com.raghunathit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghunathit.binding.Student;
import com.raghunathit.entity.StudentEntity;
import com.raghunathit.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	 public boolean saveStudent(Student student) {
		 
		 System.out.println(student);
		 StudentEntity entity=new StudentEntity();
//	entity.setName(student.getName());
//	entity.setEmail(student.getEmail());
//	entity.setCourse(student.getCourse());
//	entity.setGender(student.getGender());
//	entity.setTimings(student.getTimings());
	
	BeanUtils.copyProperties(student, entity);
 	entity.setTimings(Arrays.toString(student.getTimings()));
	
	System.out.println(entity);
	 repo.save(entity);
		 return true;
	}
	
	public List<String> getCourses(){
		return Arrays.asList("java","paython","aws","Devops");
		
	}
	
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
		
	}

}
