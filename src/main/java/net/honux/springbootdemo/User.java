package net.honux.springbootdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {

    @Id
    @JsonProperty
    private Long id;

    @JsonProperty
    private String email;

    @Embedded.Nullable
    private Github github;

    @JsonProperty
    private LocalDateTime createdDate = LocalDateTime.now();

    @MappedCollection(idColumn = "user_id")
    private Set<Game> games = new HashSet<>();

    public User(String email) {
        this.email = email;
    }

    public void addGithub(String githubId) {
        github = new Github(githubId);
    }

    public void addGame(String title) {
        games.add(new Game(title));
    }

    public void clearGame() {
        games.clear();
    }

    public Set<Game> games() {
        return games;
    }

    public Long getId() {
        return id;
    }

    public void removeGithub() {
        this.github = null;
    }

    public Github github() {
        return github;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", github=" + github +
                ", date= " + createdDate +
                ", gameCount=" + games.size() +
                '}';
    }
}
