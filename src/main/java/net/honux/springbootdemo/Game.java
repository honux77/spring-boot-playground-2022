package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private Long id;
    private int user;
    private String gameName;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public String getGameName() {
        return gameName;
    }
}
