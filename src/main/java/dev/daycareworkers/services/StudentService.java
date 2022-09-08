package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);

    List<Student> findByFirstNameAndLastName(String firstname, String lastname);

    List<Student> findByGuardianName(String gname);

    boolean deleteStudentById(int id);

    List<Student> retrieveAllStudent();

}
