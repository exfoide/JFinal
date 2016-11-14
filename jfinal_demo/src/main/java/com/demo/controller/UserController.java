package com.demo.controller;

import com.demo.interceptor.AuthIntercepter;
import com.demo.service.UserService;
import com.demo.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;


/**
 * Created by Jasper on 2016/11/4.
 */
public class UserController extends Controller {
    private UserService userService = new UserService();

    public void index(){
        renderJsp("/user/user.jsp");
    }

    @Before(LoginValidator.class)
    public void login(){
        String username = getPara("username");
        String password = getPara("password");
        boolean loginCheck = userService.login(username, password);
        if (loginCheck) {
            renderJson("10000");
            getSession().setAttribute("flag", true);
        } else {
            renderJson("10011");
        }
    }

    public void register(){
        String username = getPara("username");
        String password = getPara("password");
        boolean flag = userService.add(username, password);
        if (flag) {
            renderJson("10000");
        } else {
            renderJson("10011");
        }
    }

    @Before(AuthIntercepter.class)
    public void show(){
        renderJsp("/user/user.jsp");
    }

    public void image(){
        try {
            getFile(getPara("image", "UTF-8"));
            renderJson("20010");
        } catch (Exception e) {
            renderJson("20012");
        }
    }
}
