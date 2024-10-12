package com.iammola.spring_simple_user_rest_api.api.model;

import com.iammola.spring_simple_user_rest_api.api.interfaces.UserIdInterface;

public class User extends UserWithoutId implements UserIdInterface {
    int id;

    public User(int id, String username, String firstname, String lastname, String email, String phoneNumber) {
        super(username, firstname, lastname, email, phoneNumber);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
