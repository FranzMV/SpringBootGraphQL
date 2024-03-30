package com.graphql.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private String teacher;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, targetEntity = Student.class, cascade = CascadeType.ALL)
    private List<Student> studentList;
}
