package com.atlan.formService.Service.Impl;

import com.atlan.formService.Dao.UserDao;
import com.atlan.formService.Models.User;
import com.atlan.formService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public User add(User user) {

        user.setCreated(String.valueOf(new Date()));
        User result = dao.save(user);
        logger.info("User with UserId = " + result.getId() + " is successfully created");
        return result;
    }

    @Override
    public boolean exist(Integer id) {

        User user = dao.getById(id);

        if (user == null) {
            logger.error("User with userId = " + user.getId() + " doesn't already exist");
            return false;
        }

        return true;
    }

    @Override
    public User getById(Integer id) {

        User user = dao.getById(id);

        if (user == null) {
            logger.error("User with userId = " + user.getId() + " doesn't already exist");
            return null;
        }

        return user;

    }
}
