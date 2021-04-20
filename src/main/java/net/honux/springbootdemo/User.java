package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private Long id;
    private String email;

    public User(String email) { this.email = email; }

    public Long getId() {
        return id;
    }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}