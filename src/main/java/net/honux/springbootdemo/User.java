package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

public class User {

    @Id
    private Long id;
    private String email;

    @Embedded.Nullable
    private Github github;

    @MappedCollection(idColumn = "user_id")
    private Set<Game> games = new HashSet<>();

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", github=" + github +
                ", gameCount=" + games.size() +
                '}';
    }
}
