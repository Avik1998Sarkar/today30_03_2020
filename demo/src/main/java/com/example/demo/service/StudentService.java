package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	List<Student> findAll();

	int create(Student student);

	int update(Student student);

	int delete(Student student);

}
