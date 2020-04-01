package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

public class User {

    @Id
    private Long id;
    private String email;

    private Map<String, Game> games = new HashMap<>();

    public User(String email) {
        this.email = email;
    }

    public void addGame(String title) {
        games.put(title, new Game(title));
    }

    public void clearGame() {
        games.clear();;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public Map<String, Game> getGames() {
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
