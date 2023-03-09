package com.example.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentCrud.models.student;
import com.example.StudentCrud.service.studentService;


@RestController
@RequestMapping("/students")
public class studentController {

	@Autowired
	private studentService studentservice;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody student student){
		student id=studentservice.saveStudent(student);
		return new ResponseEntity<String>("Data Inserted Successful",HttpStatus.OK);
		
	}
	
	@GetMapping("/studentdetails")
	public ResponseEntity<List<student>> getAllStudentDetails(){
		List<student> list=studentservice.getAllStudents();
		return new ResponseEntity<List<student>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<student> getStudentById(@PathVariable("id") int id){
		student std=studentservice.getStudentById(id);
		return new ResponseEntity<student>(std, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id , @RequestBody student student){
		student stdupdate= studentservice.getStudentById(id);
		stdupdate.setName(student.getName());
		stdupdate.setEmail(student.getEmail());
		stdupdate.setMobno(student.getMobno());
		stdupdate.setGender(student.getGender());
		stdupdate.setAddr(student.getAddr());
		stdupdate.setCourse(student.getCourse());
		
		studentservice.saveStudent(stdupdate);
		student sno=studentservice.saveStudent(stdupdate);
		
		return new ResponseEntity<String>("Updated Successfull..!!",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		
		studentservice.deleteStudent(id);
		return new ResponseEntity<String>("Record has been deleted..!!",HttpStatus.OK);		
	}
}
