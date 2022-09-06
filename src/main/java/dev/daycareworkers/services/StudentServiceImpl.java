package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.exceptions.StudentNotFoundException;
import dev.daycareworkers.repos.GradeRepo;
import dev.daycareworkers.repos.StudentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    GradeRepo gradeRepo;

    Logger logger = LogManager.getLogger();

    @Override
    public Student registerStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public List<Student> findByFirstNameAndLastName(String firstname, String lastname) {
        List<Student> students = this.studentRepo.findByFnameAndLname(firstname, lastname);
        if(students.isEmpty()){
            throw new StudentNotFoundException();
        }else{
            return students;
        }
    }
    @Override
    @Transactional
    public boolean deleteStudentById(int id) {
        if(this.studentRepo.existsById(id)){
            try{
                this.gradeRepo.deleteBySid(id);
                this.studentRepo.deleteById(id);
                return true;
            }catch (RuntimeException err){
                // catch the exception when the foreign key constraint is not satisfied
                err.printStackTrace();
                logger.error("Something went wrong when deleting a student with id " + id);
                return false;
            }
        } else{
            throw new StudentNotFoundException();
        }
    }

    @Override
    public List<Student> retrieveAllStudent() {
        return this.studentRepo.findAll();
    }

}
