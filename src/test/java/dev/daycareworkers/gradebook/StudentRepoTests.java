package dev.daycareworkers.gradebook;


import dev.daycareworkers.entities.Student;
import dev.daycareworkers.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    void find_student_by_firstname_lastname(){

        Student savedStudent = this.studentRepo.save(
                new Student( 0, "adrian", "ledesma", "gaurdian")
        );

        Student foundStudent = this.studentRepo.findByFnameAndLname(
                savedStudent.getFname(), savedStudent.getLname()
        );

        Assertions.assertNotEquals(0, foundStudent.getSid());
    }

}
