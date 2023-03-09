package com.example.StudentCrud.service;

import java.util.List;

import com.example.StudentCrud.models.student;

public interface studentService {
	
	public student saveStudent(student student);
	
	public List<student> getAllStudents();
	public student getStudentById(int id);
	
	public void deleteStudent(int id);
}
