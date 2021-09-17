package com.atlan.DatabaseExportService.Service.Impl;

import com.atlan.DatabaseExportService.Dao.UserDao;
import com.atlan.DatabaseExportService.Models.User;
import com.atlan.DatabaseExportService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAllUser() {
        return dao.findAll();
    }
}
