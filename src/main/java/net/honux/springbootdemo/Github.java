package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Github {

    @Id
    private Long id;
    private String githubId;

    public Github(String githubId) {
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return "Github{" +
                "id=" + id +
                ", githubId='" + githubId + '\'' +
                '}';
    }
}
