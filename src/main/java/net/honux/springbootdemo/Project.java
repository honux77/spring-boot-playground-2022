package net.honux.springbootdemo;

import org.springframework.data.annotation.Id;

public class Project {
    @Id
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
