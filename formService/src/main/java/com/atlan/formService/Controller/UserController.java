package com.atlan.formService.Controller;

import com.atlan.formService.Models.User;

import java.util.List;

public interface UserController {

    User getUserById(Integer id);

    List<User> getAllUser();

    User addUser(User user);
}
