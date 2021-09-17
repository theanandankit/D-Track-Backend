package com.atlan.FormLoadBalanceService.Controller.Impl;

import com.atlan.FormLoadBalanceService.Controller.MainController;
import com.atlan.FormLoadBalanceService.Models.User;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserControllerImpl implements MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @GetMapping({"/user", "/users"})
    public List<User> getRedirectTo(HttpServletRequest httpServletRequest) {
        User[] users = restTemplate.getForObject(Values.FORM_URL + httpServletRequest.getRequestURI(), User[].class);
        return Arrays.asList(users);
    }

    @Override
    @PostMapping("/user")
    public Object postRedirectTo(HttpServletRequest httpServletRequest, @RequestBody User user) {
        System.out.println(user.toString());
        return restTemplate.postForEntity(Values.FORM_URL + httpServletRequest.getRequestURI(), user, User.class);
    }
}
