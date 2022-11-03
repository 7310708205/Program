package com.example.spring.Controllers;

import com.example.spring.Models.Students;
import com.example.spring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Students> saveStudent(@RequestBody Students student)
    {
        return new ResponseEntity<Students>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Students> getAllStudents()
    {
        return studentService.getAllStudents();
    }
    @GetMapping("{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Students>(studentService.getStudentById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable("id")int id,@RequestBody Students student)
    {
        return new ResponseEntity<Students>(studentService.updateStudent(student,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")int id)
    {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
}


