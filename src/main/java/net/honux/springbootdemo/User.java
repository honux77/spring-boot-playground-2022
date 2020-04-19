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

    private Set<ReadLog> readings = new HashSet<>();

    public User() {};

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

    public void addReadLog(Book book, int count) {
        ReadLog r = new ReadLog(book.getId());
        r.setCount(count);
        readings.add(r);
    }

    public void cleanReadLog() {
        readings.clear();
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

    public Set<ReadLog> getReadings() {
        return readings;
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
                ", readingsCount=" + readings.size() +
                '}';
    }
}
