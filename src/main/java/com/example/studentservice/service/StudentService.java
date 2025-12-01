package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Student get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID " + id));
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student update(Long id, Student student) {
        Student existing = get(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setBranch(student.getBranch());
        existing.setRollNumber(student.getRollNumber());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
