package dev.daycareworkers.controllers;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    @ResponseBody
    public Student registerStudent(@RequestBody Student student) {
        return this.studentService.registerStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public boolean deleteStudentById(@PathVariable String id){
        int studentId = Integer.parseInt(id);
        return this.studentService.deleteStudentById(studentId);
    }
}
