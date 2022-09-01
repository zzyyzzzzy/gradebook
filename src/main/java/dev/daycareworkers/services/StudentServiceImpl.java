package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student registerStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public List<Student> findByFirstNameAndLastName(String firstname, String lastname) {
        return this.studentRepo.findByFnameAndLname(firstname, lastname);
    }

}
