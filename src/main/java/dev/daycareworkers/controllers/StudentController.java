package dev.daycareworkers.controllers;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    @ResponseBody
    public Student registerStudent(@RequestBody Student student) {
        return this.studentService.registerStudent(student);
    }
}
