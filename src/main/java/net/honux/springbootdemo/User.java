package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

public class User {

    @Id
    private Long id;
    private String email;

    @Embedded.Nullable
    private Github github;

    public void addGithub(String githubId) {
        github = new Github(githubId);
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
                '}';
    }
}
