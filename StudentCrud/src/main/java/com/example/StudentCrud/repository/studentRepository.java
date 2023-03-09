package com.example.StudentCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.StudentCrud.models.student;

public interface studentRepository extends CrudRepository<student, Integer> {

}
