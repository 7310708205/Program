package com.example.spring.Service;
import com.example.spring.Models.Students;
import com.example.spring.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepo studentRepo;

    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo=studentRepo;
    }

    @Override
    public Students saveStudent(Students student) {
        return studentRepo.save(student);
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Students getStudentById(int id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public Students updateStudent(Students student, int id) {
        Students existingStudent=studentRepo.findById(id).orElseThrow();
        existingStudent.setFname(student.getFname());
        existingStudent.setLname(student.getLname());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setEmail(student.getEmail());
        studentRepo.save(existingStudent);
        return existingStudent;
    }
    public void deleteStudent(int id) {
        studentRepo.findById(id).orElseThrow();
        studentRepo.deleteById(id);
    }
}
