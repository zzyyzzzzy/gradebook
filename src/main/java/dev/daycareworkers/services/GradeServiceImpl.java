package dev.daycareworkers.services;

import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepo gradeRepo;

    @Override
    public Grade registerGrade(Grade grade) {

        Grade savedGrade = this.gradeRepo.save(grade);
        return savedGrade;
    }
}
