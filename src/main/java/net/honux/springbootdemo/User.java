package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class User {

    @Id
    private Long id;
    private String email;
    private LocalDateTime createdDate = LocalDateTime.now();

    private Github github;

    public User(String email, Github github) {
        this.email = email;
        this.github = github;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Github getGithub() {
        return github;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", github=" + github +
                '}';
    }

    public void setGithub(Github github) {
        this.github = github;
    }
}
