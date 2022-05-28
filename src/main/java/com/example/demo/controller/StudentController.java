package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentService service;

	public StudentController(@Autowired StudentService service){
		this.service=service;
	}

	@PostMapping("")
	public ResponseEntity<Integer> postStudent(@RequestBody Student newStudent){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(newStudent).getId());
    }

	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> fetchStudentById(@PathVariable("studentId") int studentId){
		return service.getStudentById(studentId)
			.map(Student-> ResponseEntity.ok().body(Student))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
    
}
