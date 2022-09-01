package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.Behavior;
import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.repos.GradeRepo;
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

}
