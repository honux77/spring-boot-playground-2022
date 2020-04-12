package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Book {

    @Id
    Long id;

    String title;

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titie='" + title + '\'' +
                '}';
    }
}
