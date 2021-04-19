package net.honux.springbootdemo;

public class Github {

    private String nickname;

    public Github(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Github{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}