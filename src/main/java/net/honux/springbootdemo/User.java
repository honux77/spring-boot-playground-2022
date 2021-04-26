package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.*;

public class User {

    @Id
    private Long id;
    private String email;
    private String name;
    @Embedded.Nullable
    private Github github;

    @MappedCollection(keyColumn="name")
    private Map<String, Food> foods = new HashMap<>();

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public void addFoods(Food... foods) {
        for(Food f: foods) {
            this.foods.put(f.name, f);
        }
    }

    public Collection<Food> getFoods() {
        return foods.values();
    }

    public Food getFood(String name) {
        return foods.get(name);
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