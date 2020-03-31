package net.honux.springbootdemo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select u.id, u.email, g.user as github_user, g.nickname as github_nickname from"
            + " user u left outer join github g on u.id = g.user"
            + " where u.email = :email")
    Optional<User> findUserByEmail(String email);

}
