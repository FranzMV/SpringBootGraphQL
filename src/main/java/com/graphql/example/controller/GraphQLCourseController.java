package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id){
        return courseService.findById(Long.parseLong(id));
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll(){
        return courseService.findAll();

    }
}
