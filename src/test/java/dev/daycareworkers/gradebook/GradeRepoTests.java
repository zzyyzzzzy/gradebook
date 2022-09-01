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

import java.util.List;

@SpringBootTest
@Transactional
public class GradeRepoTests {

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    StudentRepo studentRepo;

    @Test
    public void create_grade_test() {
        Grade grade = new Grade(0, -1, 1000, "Test Note", Behavior.GOOD);
        Grade savedGrade = this.gradeRepo.save(grade);
        Assertions.assertNotEquals(0, savedGrade.getGid());
    }

    @Test
    public void get_grades_by_sid() {
        Grade grade1 = new Grade(0, -1, 1000, "Test Note", Behavior.GOOD);
        this.gradeRepo.save(grade1);
        Grade grade2 = new Grade(0, -1, 1000, "Test Note", Behavior.GOOD);
        this.gradeRepo.save(grade2);
        List<Grade> studentGrades = this.gradeRepo.findGradesBySid(-1);
        Assertions.assertEquals(2,studentGrades.size());
    }
    @Test
    void delete_grades_by_sid(){
        Student student = new Student(0,"Billy","Bobson","William Bobson");
        Student savedStudent = this.studentRepo.save(student);
        Grade grade = new Grade(1,savedStudent.getSid(), 0, "test", Behavior.BAD);
        Grade savedGrade = this.gradeRepo.save(grade);
        this.gradeRepo.deleteBySid(savedStudent.getSid());
        Assertions.assertFalse(this.gradeRepo.existsById(savedGrade.getGid()));
    }

}
