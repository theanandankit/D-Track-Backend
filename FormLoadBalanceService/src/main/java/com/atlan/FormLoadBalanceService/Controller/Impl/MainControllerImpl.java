package com.atlan.FormLoadBalanceService.Controller.Impl;

import com.atlan.FormLoadBalanceService.Controller.MainController;
import com.atlan.FormLoadBalanceService.Utils.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainControllerImpl implements MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @GetMapping("/users")
    public String redirectTo(HttpServletRequest httpServletRequest) {

        return restTemplate.getForObject(Values.FORM_URL + httpServletRequest.getRequestURI(), String.class);

    }
}
