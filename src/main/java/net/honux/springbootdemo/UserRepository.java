package net.honux.springbootdemo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select * from user where email = :email")
    Optional<User> findUserByEmail(String email);
}
