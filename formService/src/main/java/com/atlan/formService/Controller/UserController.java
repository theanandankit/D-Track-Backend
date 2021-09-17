package com.atlan.formService.Controller;

import com.atlan.formService.Models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {

    ResponseEntity<User> getUserById(Integer id);

    ResponseEntity<List<User>> getAllUser();

    ResponseEntity<User> addUser(User user);
}
