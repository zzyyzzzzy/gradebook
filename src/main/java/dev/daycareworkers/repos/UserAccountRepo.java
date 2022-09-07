package dev.daycareworkers.repos;

import dev.daycareworkers.entities.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends MongoRepository<UserAccount, String> {

    @Query("{'username':'?0'}")
    UserAccount findByUsername(String username);
}
