package dev.daycareworkers.controllers;

import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/grades")
    @ResponseBody
    public ResponseEntity<Grade> registerGrade(@RequestBody Grade grade) {
        return new ResponseEntity<Grade>(this.gradeService.registerGrade(grade), HttpStatus.CREATED);
    }
}
