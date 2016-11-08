package com.demo.blog.controller;

import com.demo.blog.interceptor.BlogInterceptor;
import com.demo.blog.model.Blog;
import com.demo.blog.validator.BlogValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * BlogController
 * ���� sql ��ҵ���߼�д�� Model �� Service �У���Ҫд�� Controller �У����ɺ�ϰ�ߣ������ڴ�����Ŀ�Ŀ�����ά��
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
    public void index(){
        setAttr("blogPage", Blog.blog.paginate(getParaToInt(0, 1), 10));
        render("blog.html");
    }

    public void add(){
        redirect("/blog/add.html");
    }

    @Before(BlogValidator.class)
    public void save(){
        getModel(Blog.class).save();
        redirect("/blog");
    }

    public void edit(){
        setAttr("blog", Blog.blog.findById(getParaToInt()));
    }

    @Before(BlogValidator.class)
    public void update(){
        getModel(Blog.class).update();
        redirect("/blog");
    }

    public void delete(){
        Blog.blog.deleteById(getParaToInt());
        redirect("/blog");
    }
}
