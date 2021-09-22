package com.atlan.SMSService.Service;

import com.atlan.SMSService.Models.User;
import com.atlan.SMSService.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getUserContact(Integer id) {

//        User user = userRepository.getById(id);
//        return String.valueOf(Integer.parseInt(user.getContactNo()));

        return "+919024923695";

    }
}
