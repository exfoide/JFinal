package com.demo.blog.controller;

import com.jfinal.core.Controller;

/**
 * Created by Jasper on 2016/11/7.
 */
public class IndexController extends Controller {
    public void index(){
        render("index.html");
    }
}
