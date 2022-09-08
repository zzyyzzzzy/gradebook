package dev.daycareworkers.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.exceptions.InvalidJWTException;
import dev.daycareworkers.exceptions.UnauthorizedUserException;
import dev.daycareworkers.services.GradeService;
import dev.daycareworkers.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;
    @Autowired
    JwtService jwtService;
    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping("/grades")
    @ResponseBody
    public ResponseEntity<Grade> registerGrade(@RequestBody Grade grade, @RequestHeader("auth") String jwt) {
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            if (role.equals("teacher")) {
                Date currentTime = new Date(System.currentTimeMillis());
                String message = "New grade created for student id number " + grade.getSid() +
                        ". Time: " + currentTime.toString();
                jmsTemplate.convertAndSend("important-event-queue", message);

                return new ResponseEntity<Grade>(this.gradeService.registerGrade(grade), HttpStatus.CREATED);
            }
            throw new UnauthorizedUserException();
        }
        throw new InvalidJWTException();

    }

    @GetMapping("/grades/{id}")
    @ResponseBody
    public List<Grade> gradesBySid(@PathVariable int id, @RequestHeader("auth") String jwt) {
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            //int sid = Integer.parseInt(id);
            return this.gradeService.findGradesBySid(id);

        }
        throw new InvalidJWTException();
    }

    @DeleteMapping("/grades/{id}")
    @ResponseBody
    public boolean deleteGradeById(@PathVariable String id, @RequestHeader("auth") String jwt){
        if (jwtService.validateJWT(jwt)) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            String role = decodedJWT.getClaim("role").asString();

            if (role.equals("teacher")) {
                int gid = Integer.parseInt(id);
                Date currentTime = new Date(System.currentTimeMillis());
                String message = "Grade deleted from student id number " + gid + ". Time: " + currentTime.toString();
                jmsTemplate.convertAndSend("important-event-queue", message);

                return this.gradeService.deleteGradeById(gid);
            }
            throw new UnauthorizedUserException();
        }
        throw new InvalidJWTException();
    }
}
