package com.example.spring.Service;

import com.example.spring.Models.Students;
import java.util.List;

public interface StudentService {
    Students saveStudent(Students student);
    List<Students> getAllStudents();
    Students getStudentById(int id);
    Students updateStudent(Students student, int id);

    void deleteStudent(int id);
}
