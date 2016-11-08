package com.demo.blog.model;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by Jasper on 2016/11/7.
 */
@SuppressWarnings("serial")
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {
    public void setId(java.lang.Integer id){
        set("id", id);
    }

    public java.lang.Integer getId(){
        return get("id");
    }

    public void setTitle(java.lang.String title) {
        set("title", title);
    }

    public String getTitle(){
        return get("title");
    }

    public void setContent(java.lang.String content) {
        set("content", content);
    }

    public java.lang.String getContent(){
        return get("content");
    }
}

