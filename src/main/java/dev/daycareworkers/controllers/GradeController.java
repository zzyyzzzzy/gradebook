package dev.daycareworkers.controllers;

import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/grades")
    @ResponseBody
    public ResponseEntity<Grade> registerGrade(@RequestBody Grade grade) {
        return new ResponseEntity<Grade>(this.gradeService.registerGrade(grade), HttpStatus.CREATED);
    }

    @GetMapping("/grades/{id}")
    @ResponseBody
    public List<Grade> gradesBySid(@PathVariable int id) {
        //int sid = Integer.parseInt(id);
        return this.gradeService.findGradesBySid(id);
    }

    @DeleteMapping("/grades/{id}")
    @ResponseBody
    public boolean deleteGradeById(@PathVariable String id){
        int gid = Integer.parseInt(id);
        return this.gradeService.deleteGradeById(gid);
    }
}
