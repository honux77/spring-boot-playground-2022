package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    private Long id;
    private String email;
    private LocalDateTime createdDate = LocalDateTime.now();
    private List<Game> games = new ArrayList<>();

    private Github github;

    public User() {
        super();
    }

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

    public void setGithub(Github github) {
        this.github = github;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void removeAllGame() {
        this.games.clear();
    }

    public List<Game> getGames() {
        return this.games;
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
}
