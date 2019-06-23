package com.university.service;

import com.university.model.Student;
import com.university.repository.GroupRepository;
import com.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DataStudentService implements StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public GroupRepository groupRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void add(Student student) {
        if (student.getIdGroup() != null) {
            student.setGroup(groupRepository.getOne(student.getIdGroup()));
        }
        studentRepository.save(student);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Student student) {
        if (student.getIdGroup() != null) {
            student.setGroup(groupRepository.getOne(student.getIdGroup()));
        }
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByFullNameStartingWith(String filter) {
        return studentRepository.findByFullNameStartingWith(filter);
    }
}
