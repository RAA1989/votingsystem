package com.projects.votingsystem;


import com.projects.votingsystem.model.User;



public class AuthorizedUser extends org.springframework.security.core.userdetails.User{

    private int id;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.id = user.getId();
    }

    public int getId(){
        return this.id;
    }

}
