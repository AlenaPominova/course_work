package ru.vsu.amm.model;

import java.util.Set;

public class Role {
    private int id;
    private String name;
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return Role.class.getSimpleName() +
                "{name='" + name + '\'' +
                ", id=" + id + '}';
    }
}
