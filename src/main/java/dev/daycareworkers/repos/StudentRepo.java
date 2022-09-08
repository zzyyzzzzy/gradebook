package dev.daycareworkers.repos;

import dev.daycareworkers.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByFnameAndLname(String firstname, String lastname);
    List<Student> findByGname(String gname);


}
