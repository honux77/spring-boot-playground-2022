package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.HashSet;
import java.util.Set;

public class User {

    @Id
    private Long id;
    private String email;
    private String name;
    @Embedded.Nullable
    private Github github;

    private Set<Food> foods = new HashSet<>();

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public void addFoods(Food... foods) {
        for(Food f: foods) {
            this.foods.add(f);
        }
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() { return email; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Github getGithub() {
        return github;
    }

    public void setGithub(Github github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", github=" + github +
                '}';
    }
}