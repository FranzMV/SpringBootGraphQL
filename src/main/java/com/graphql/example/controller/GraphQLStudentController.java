package com.graphql.example.controller;

import com.graphql.example.entities.Student;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {

    @Autowired
    private IStudentService studentService;

    @QueryMapping(name = "findStudentById")
    public Student findByID(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);
        return  studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
