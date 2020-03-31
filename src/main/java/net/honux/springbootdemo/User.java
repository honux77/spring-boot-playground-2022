package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class User {

    @Id
    private Long id;
    private String email;

    private Set<Game> games = new HashSet<>();

    public User(String email) {
        this.email = email;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public Set<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", numGame='" + games.size() + '\'' +
                '}';
    }
}
