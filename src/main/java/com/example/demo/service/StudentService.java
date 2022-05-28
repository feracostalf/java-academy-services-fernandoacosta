package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

	
	public StudentService(@Autowired StudentRepository repository){
		this.repository=repository;
	}

    public Student saveStudent( Student newStudent){
		return repository.save(newStudent);
    }
    
    public Optional<Student> getStudentById( int studentId){
		return repository.findById(studentId);
	}
}
