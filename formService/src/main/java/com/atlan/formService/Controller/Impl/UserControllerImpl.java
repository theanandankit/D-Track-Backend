package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.UserController;
import com.atlan.formService.Models.User;
import com.atlan.formService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(name = "id") Integer id) {

        User user = userService.getById(id);

        if (user != null) {
            return user;
        }

        return null;
    }

    @Override
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @Override
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }
}
