package com.demo.blog.validator;

import com.demo.blog.model.Blog;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * Created by Jasper on 2016/11/7.
 */
public class BlogValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        validateRequiredString("blog.title", "titleMsg", "请输入Blog标题!");
        validateRequiredString("blog.content", "contentMsg", "请输入Blog内容!");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepModel(Blog.class);
        String actionKey = getActionKey();
        if (actionKey.contains("/blog/save")){
            controller.render("add.html");
        }
        if (actionKey.contains("/blog/update")){
            controller.render("update.html");
        }
    }
}
