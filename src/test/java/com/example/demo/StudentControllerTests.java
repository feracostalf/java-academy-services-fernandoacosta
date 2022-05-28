package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.controller.StudentController;
import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

public class StudentControllerTests {

    @Mock
    StudentController studentcontroller;

    @InjectMocks
    StudentService service;

    @Before
    public void setup() {
        studentcontroller=new StudentController(service);
    }
    
    @Test
    @Order(1)
    public void postStudent() {  
        Student std1= new Student("Fernando","Acosta","1996-01-19","M");
        assertEquals(std1, studentcontroller.postStudent(std1));
    } 

    
}
