package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student registerStudent(Student student) {
        Student savedStudent = this.studentRepo.save(student);
        return savedStudent;
    }
}
