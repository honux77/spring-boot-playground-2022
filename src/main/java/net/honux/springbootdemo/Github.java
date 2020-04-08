package net.honux.springbootdemo;

import org.springframework.data.relational.core.mapping.Column;

public class Github {

    @Column("github_id")
    private String id;

    public Github(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Github{" +
                "id='" + id + '\'' +
                '}';
    }
}
