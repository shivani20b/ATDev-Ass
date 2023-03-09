package com.example.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.models.student;
import com.example.StudentCrud.repository.studentRepository;

@Service
public class ServiceStud implements studentService{

	@Autowired
	private studentRepository repository;
	
	
	@Override
	public student saveStudent(student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public List<student> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<student>) repository.findAll();
	}

	@Override
	public student getStudentById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		
	}

}
