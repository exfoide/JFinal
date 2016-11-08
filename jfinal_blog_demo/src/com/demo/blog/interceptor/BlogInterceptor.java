package com.demo.blog.interceptor;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by Jasper on 2016/11/7.
 */
public class BlogInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before invoking:" + invocation.getActionKey());
        invocation.invoke();
        System.out.println("After invoking:" + invocation.getActionKey());
    }
}
