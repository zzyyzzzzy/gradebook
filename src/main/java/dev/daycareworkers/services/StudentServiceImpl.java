package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.exceptions.StudentNotFoundException;
import dev.daycareworkers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student registerStudent(Student student) {
        Student savedStudent = this.studentRepo.save(student);
        return savedStudent;
    }

    @Override
    public boolean deleteStudentById(int id) {
        if(this.studentRepo.existsById(id)){
            this.studentRepo.deleteById(id);
            return true;
        } else{
            throw new StudentNotFoundException();
        }
    }
}
