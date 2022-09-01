package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.Behavior;
import dev.daycareworkers.entities.Grade;
import dev.daycareworkers.repos.GradeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

}
