package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDao {
	int create(Student student);

	int update(Student student);

	int delete(Student student);

	List<Student> findAll();
}
