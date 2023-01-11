package com.vts.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vts.redis.model.Student;
import com.vts.redis.repository.StudentRepo;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@PostMapping
	public Student saveDetails(@RequestBody Student student) {	
		return repo.save(student);
	}
	
	@GetMapping
	public List<Student> getAllDetails(){
		return repo.getAll();
		
	}
	
	@GetMapping("/{id}")
	public Object getDetailById(@PathVariable int id) {
	return	repo.findStudentById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteDetails(@PathVariable int id) {
		repo.deleteById(id);
		return "removed successfully";
		
	}
	
	@PostMapping("/add")
	public String saveAll() {
		
		Student stu = new Student();
		for(int i=0; i<100; i++) {
			stu.setId(i);
			stu.setName("XYZ" + i);
			stu.setSchool("ABC" + i);
			
			repo.save(stu);
		}
		return "saved successfully";
	}

}
