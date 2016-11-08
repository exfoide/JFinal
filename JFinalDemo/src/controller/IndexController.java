package controller;

import com.jfinal.core.Controller;

/**
 * Created by Jasper on 2016/11/4.
 */
public class IndexController extends Controller {
    public void index(){
        renderJsp("index.jsp");
    }
}
