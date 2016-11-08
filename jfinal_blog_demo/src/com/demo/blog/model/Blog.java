package com.demo.blog.model;

import com.jfinal.plugin.activerecord.Page;

/**
 * Created by Jasper on 2016/11/7.
 */
@SuppressWarnings("serial")
public class Blog extends BaseBlog<Blog> {
    public static final Blog blog = new Blog();

    /**
     * 所有sql与业务逻辑写在Model或Service中，不要写在Controller中，有利于大型项目的开发维护
     */
    public Page<Blog> paginate(int pageNumber, int pageSize){
        return paginate(pageNumber, pageSize, "select * ", "from blog order by id asc");
    }
}

