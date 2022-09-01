package dev.daycareworkers.controllers;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    @ResponseBody
    public Student registerStudent(@RequestBody Student student) {
        return this.studentService.registerStudent(student);
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> findByFirstNameAndLastName(@RequestParam String firstname, String lastname){
        return this.studentService.findByFirstNameAndLastName(firstname, lastname);
    }

}
