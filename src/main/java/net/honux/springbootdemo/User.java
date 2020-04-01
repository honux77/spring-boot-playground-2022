package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    private Long id;
    private String email;

    private List<Game> games = new ArrayList<>();

    public User(String email) {
        this.email = email;
    }

    public void addGame(String title) {
        games.add(new Game(title));
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

    public List<Game> getGames() {
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
