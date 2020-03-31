package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class User {

    @Id
    private Long id;
    private String email;
    private LocalDateTime createdDate;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
