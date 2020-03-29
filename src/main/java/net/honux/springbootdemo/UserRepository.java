package net.honux.springbootdemo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select u.id, u.email, u.created_date, g.user as github_user, g.email as github_email, g.github_id as github_github_id"
            + " from user u left join github g on u.id = g.user"
            + " where u.email = :email")
    Optional<User> findUserByEmail(String email);
}
