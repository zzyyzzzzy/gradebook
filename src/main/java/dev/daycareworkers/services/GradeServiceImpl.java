package dev.daycareworkers.services;

import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.exceptions.GradeNotFoundException;
import dev.daycareworkers.exceptions.StudentNotFoundException;
import dev.daycareworkers.repos.GradeRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepo gradeRepo;
    Logger logger = LogManager.getLogger();

    public GradeServiceImpl() {
    }

    public GradeServiceImpl(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    @Override
    public Grade registerGrade(Grade grade) {

        Grade savedGrade = this.gradeRepo.save(grade);
        return savedGrade;
    }

    @Override
    public List<Grade> findGradesBySid(int id) {
        return this.gradeRepo.findGradesBySid(id);
    }

    @Override
    public boolean deleteGradeById(int id) {
        if(this.gradeRepo.existsById(id)){
            try{
                this.gradeRepo.deleteById(id);
                return true;
            }catch (RuntimeException err){
                // catch the exception when the foreign key constraint is not satisfied
                logger.error("Something went wrong when deleting a grade with id " + id);
                return false;
            }
        } else{
            throw new GradeNotFoundException();
        }
    }
}
