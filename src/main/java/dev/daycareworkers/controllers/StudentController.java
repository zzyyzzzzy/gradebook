package dev.daycareworkers.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.daycareworkers.entities.Student;
import dev.daycareworkers.exceptions.InvalidJWTException;
import dev.daycareworkers.exceptions.UnauthorizedUserException;
import dev.daycareworkers.services.JwtService;
import dev.daycareworkers.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    JwtService jwtService;

    @PostMapping("/students")
    @ResponseBody
    public Student registerStudent(@RequestBody Student student, @RequestHeader("auth") String jwt) {
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            if (role.equals("teacher")) {
                return this.studentService.registerStudent(student);
            }
            throw new UnauthorizedUserException();
        }
        throw new InvalidJWTException();

    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> findByFirstNameAndLastName(@RequestParam(required = false) String firstname, String lastname,
                                                    @RequestHeader("auth") String jwt){
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            if(firstname == null && lastname == null){
                return this.studentService.retrieveAllStudent();
            } else{
                return this.studentService.findByFirstNameAndLastName(firstname, lastname);
            }
        }
        throw new InvalidJWTException();
    }

    @DeleteMapping("/students/{id}")
    @ResponseBody
    public boolean deleteStudentById(@PathVariable String id, @RequestHeader("auth") String jwt){
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            if (role.equals("teacher")) {
                int studentId = Integer.parseInt(id);
                return this.studentService.deleteStudentById(studentId);
            }
            throw new UnauthorizedUserException();
        }
        throw new InvalidJWTException();
    }


}
