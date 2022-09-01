package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.exceptions.StudentNotFoundException;
import dev.daycareworkers.repos.StudentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.sql.SQLException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    Logger logger = LogManager.getLogger();

    @Override
    public Student registerStudent(Student student) {
        Student savedStudent = this.studentRepo.save(student);
        return savedStudent;
    }

    @Override
    public boolean deleteStudentById(int id) {
        if(this.studentRepo.existsById(id)){
            try{
                this.studentRepo.deleteById(id);
                return true;
            }catch (RuntimeException err){
                // catch the exception when the foreign key constraint is not satisfied
                logger.error("Something went wrong when deleting a student with id " + id);
                return false;
            }
        } else{
            throw new StudentNotFoundException();
        }
    }
}
