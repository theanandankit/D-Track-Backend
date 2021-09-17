package com.atlan.formService.Controller.Impl;

import com.atlan.formService.Controller.UserController;
import com.atlan.formService.Models.User;
import com.atlan.formService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Integer id) {

        User user = userService.getById(id);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @Override
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.add(user));
    }
}
