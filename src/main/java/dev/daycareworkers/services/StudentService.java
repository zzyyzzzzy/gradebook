package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;

public interface StudentService {

    Student registerStudent(Student student);

    Student findByFirstNameAndLastName(String firstname, String lastname);


}
