package dev.daycareworkers.gradebook;

import dev.daycareworkers.entities.Student;
import dev.daycareworkers.exceptions.GradeNotFoundException;
import dev.daycareworkers.exceptions.StudentNotFoundException;
import dev.daycareworkers.repos.GradeRepo;
import dev.daycareworkers.repos.StudentRepo;
import dev.daycareworkers.services.GradeService;
import dev.daycareworkers.services.GradeServiceImpl;
import dev.daycareworkers.services.StudentService;
import dev.daycareworkers.services.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTests {

    static StudentRepo studentRepo = Mockito.mock(StudentRepo.class);
    static GradeRepo gradeRepo = Mockito.mock(GradeRepo.class);
    static StudentService studentService = new StudentServiceImpl(studentRepo);
    static GradeService gradeService = new GradeServiceImpl(gradeRepo);

    @Test
    public void find_student_by_first_and_last_name_nothing_found_test() {
        List<Student> studentList = new ArrayList();
        Mockito.when(studentRepo.findByFnameAndLname("a", "a")).thenReturn(studentList);
        Assertions.assertThrows(StudentNotFoundException.class, () ->
                studentService.findByFirstNameAndLastName("a", "a"));
    }

    @Test
    public void delete_student_by_id_doesnt_exist_test() {
        int id = 12345;
        Mockito.when(studentRepo.existsById(id)).thenReturn(false);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.deleteStudentById(id));
    }

    @Test
    public void delete_grade_by_id_doesnt_exist_test() {
        int id = 12345;
        Mockito.when(gradeRepo.existsById(id)).thenReturn(false);
        Assertions.assertThrows(GradeNotFoundException.class, () -> gradeService.deleteGradeById(id));
    }

}
