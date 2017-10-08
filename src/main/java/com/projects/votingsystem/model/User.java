package com.projects.votingsystem.model;

import java.util.Set;


public class User extends NamedEntity {

    private String email;

    private String password;

    private Set<Role> roles;

    private Vote vote;

    public User(){}

    public User(Integer id, String name, String email, String password, Set<Role> roles, Vote vote) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", vote=" + vote +
                '}';
    }
}
