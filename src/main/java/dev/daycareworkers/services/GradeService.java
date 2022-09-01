package dev.daycareworkers.services;

import dev.daycareworkers.entities.Grade;

import java.util.List;

public interface GradeService {

    Grade registerGrade(Grade grade);

    List<Grade> findGradesBySid(int id);
    boolean deleteGradeById(int id);
}
