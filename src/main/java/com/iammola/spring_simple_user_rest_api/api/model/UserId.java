package com.iammola.spring_simple_user_rest_api.api.model;

import com.iammola.spring_simple_user_rest_api.api.interfaces.UserIdInterface;

public class UserId implements UserIdInterface {
    int id;

    public UserId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
