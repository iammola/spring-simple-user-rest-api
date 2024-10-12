package com.iammola.spring_simple_user_rest_api.api.controller;

import com.iammola.spring_simple_user_rest_api.api.model.User;
import com.iammola.spring_simple_user_rest_api.api.model.UserId;
import com.iammola.spring_simple_user_rest_api.api.model.UserWithoutId;

import com.iammola.spring_simple_user_rest_api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserId createUser(@Validated @RequestBody UserWithoutId user) {
      return userService.addUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@PathVariable("id") int id) throws ResponseStatusException {
        User user = userService.getUser(id);

        if (user == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public User updateUser(@PathVariable("id") int id, @Validated @RequestBody UserWithoutId body) throws ResponseStatusException{
        User updatedUser = userService.updateUser(id, body);
        if (updatedUser == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return updatedUser;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public UserId deleteUser(@PathVariable("id") int id) throws ResponseStatusException {
        UserId deletedUser = userService.deleteUser(id);

        if (deletedUser == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return deletedUser;
    }
}
