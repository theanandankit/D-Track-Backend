package com.atlan.formService.Service;

import com.atlan.formService.Models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User add(User user);

    boolean exist(Integer id);

    User getById(Integer id);
}
