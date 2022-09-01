package dev.daycareworkers.services;

import dev.daycareworkers.entities.Student;

public interface StudentService {

    Student registerStudent(Student student);

    boolean deleteStudentById(int id);
}
