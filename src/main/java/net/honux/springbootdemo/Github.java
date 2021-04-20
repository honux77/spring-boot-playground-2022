package net.honux.springbootdemo;

public class Github {
    private String nickname;
    private String photoUrl;

    public Github(String nickname, String photoUrl) {
        this.nickname = nickname;
        this.photoUrl = photoUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Github{" +
                "nickname='" + nickname + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
