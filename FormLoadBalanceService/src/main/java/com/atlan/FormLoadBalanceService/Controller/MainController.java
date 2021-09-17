package com.atlan.FormLoadBalanceService.Controller;

import com.atlan.FormLoadBalanceService.Models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainController {

    List<User> getRedirectTo(HttpServletRequest httpServletRequest);

    Object postRedirectTo(HttpServletRequest httpServletRequest, User user);
}
