package dev.daycareworkers.repos;

import dev.daycareworkers.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {

    List<Grade> findGradesBySid(int sid);
    void deleteBySid(int sId);

}
