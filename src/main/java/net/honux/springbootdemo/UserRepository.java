package net.honux.springbootdemo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByName(String name);
    Optional<User> findUserByEmail(String email);
}