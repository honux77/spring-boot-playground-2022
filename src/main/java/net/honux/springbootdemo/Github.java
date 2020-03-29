package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Github {
    @Id
    private Long user;
    private String email;
    private String githubId;

    public Github(String email, String githubId) {
        this.email = email;
        this.githubId = githubId;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return "Github{" +
                "user=" + user +
                ", email='" + email + '\'' +
                ", githubId='" + githubId + '\'' +
                '}';
    }
}
