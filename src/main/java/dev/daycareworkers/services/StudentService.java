package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);

    List<Student> findByFirstNameAndLastName(String firstname, String lastname);


}
