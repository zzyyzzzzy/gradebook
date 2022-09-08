package dev.daycareworkers.gradebook;


import dev.daycareworkers.entities.Student;
import dev.daycareworkers.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class StudentRepoTests {

    @Autowired
    StudentRepo studentRepo;

    @Test
    void add_student_test() {
        Student student = new Student(0,"Billy","Bobson","William Bobson");
        Student savedStudent = this.studentRepo.save(student);
        Assertions.assertNotEquals(0,savedStudent.getSid());
//        Student savedStudent = this.studentRepo.save(student);

    }

    @Test
    void find_student_by_firstname_lastname_test(){

        Student savedStudent = this.studentRepo.save(
                new Student( 0, "adrian", "ledesma", "gaurdian")
        );

        List<Student> students = this.studentRepo.findByFnameAndLname(
                savedStudent.getFname(), savedStudent.getLname()
        );

        Assertions.assertNotEquals(0, students.size());
    }

    @Test
    void find_student_by_guardian_name_test() {
        Student savedStudent = this.studentRepo.save(
                new Student( 0, "adrian", "ledesma", "gaurdian"));

        List<Student> students = this.studentRepo.findByGname(savedStudent.getGname());

        Assertions.assertNotEquals(0, students.size());
    }

}
