package com.iammola.spring_simple_user_rest_api.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iammola.spring_simple_user_rest_api.api.model.User;
import com.iammola.spring_simple_user_rest_api.api.model.UserId;
import com.iammola.spring_simple_user_rest_api.api.model.UserWithoutId;



@Service
public class UserService {
    private final ArrayList<User> userList = new ArrayList<>();

    public UserService() {
        addUser(new UserWithoutId("c.west", "Charlotte", "West", "ukga@ze.au", "(243) 969-1016"));
        addUser(new UserWithoutId("hey!lucas", "Lucas", "Fowler", "ve@iwepke.va", "(773) 867-2377"));
        addUser(new UserWithoutId("bush.cecil", "Cecilia", "Bush", "wel@pogjo.sv", "(979) 858-8031"));
        addUser(new UserWithoutId("sallie_says", "Sallie", "Owen", "hiifbo@lezwika.gt", "(417) 329-9464"));
        addUser(new UserWithoutId("janie101", "Janie", "Colon", "cotto@icasu.br", "(927) 668-3335"));
    }

    public UserId addUser(UserWithoutId data) {
        User createdUser = new User(userList.size(), data.getUserName(), data.getFirstName(), data.getLastName(), data.getEmail(), data.getPhoneNumber());
        userList.add(createdUser);

        System.out.println("Created User. ID=" + createdUser.getId() + " username = " + createdUser.getUserName());

        return new UserId(createdUser.getId());
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public com.iammola.spring_simple_user_rest_api.api.model.User getUser(int id) {
        return userList.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public User updateUser(int id, UserWithoutId data) {
        User user = userList.stream().filter(item -> item.getId() == id).findFirst().orElse(null);

        if (user == null) return null;

        user.setUserName(data.getUserName());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPhoneNumber(data.getPhoneNumber());

        return user;
    }

    public UserId deleteUser(int id) {
        int currentUserCount = userList.size();
        userList.removeIf(user -> user.getId() == id);

        if (userList.size() == currentUserCount) return null;

        return new UserId(id);
    }
}
