package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.Behavior;
import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.entities.Student;
import dev.daycareworkers.repos.GradeRepo;
import dev.daycareworkers.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GradeRepoTests {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Test
    void delete_grades_by_sid(){
//        insert into grade values(default, 19, 0, 'grade', 'Bad');
        Student student = new Student(0,"Billy","Bobson","William Bobson");
        Student savedStudent = this.studentRepo.save(student);
        Grade grade = new Grade(1,savedStudent.getSid(), 0, "test", Behavior.BAD);
        Grade savedGrade = this.gradeRepo.save(grade);
        this.gradeRepo.deleteBySid(savedStudent.getSid());
        Assertions.assertFalse(this.gradeRepo.existsById(savedGrade.getGid()));
    }
}
