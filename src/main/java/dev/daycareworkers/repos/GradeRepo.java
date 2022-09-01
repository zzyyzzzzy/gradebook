package dev.daycareworkers.repos;

import dev.daycareworkers.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {
    void deleteBySid(int sId);
}
