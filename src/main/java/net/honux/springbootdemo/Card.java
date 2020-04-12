package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Card {

    @Id
    private Long id;
    private String contents;

    private Long userId;

    public Card(String contents) {
        this.contents = contents;
    }

    public void setUser(User user) {
        this.userId = user.getId();
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", userId=" + userId +
                '}';
    }
}
