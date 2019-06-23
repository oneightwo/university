package com.university.service;

import com.university.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void add(Student student);

    void delete(Long id);

    void update(Student student);

    List<Student> findByFullNameStartingWith(String filter);
}
