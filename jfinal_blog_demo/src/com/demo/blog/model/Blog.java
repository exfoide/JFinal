package com.demo.blog.model;

import com.jfinal.plugin.activerecord.Page;

/**
 * Created by Jasper on 2016/11/7.
 */
@SuppressWarnings("serial")
public class Blog extends BaseBlog<Blog> {
    public static final Blog blog = new Blog();

    /**
     * ����sql��ҵ���߼�д��Model��Service�У���Ҫд��Controller�У������ڴ�����Ŀ�Ŀ���ά��
     */
    public Page<Blog> paginate(int pageNumber, int pageSize){
        return paginate(pageNumber, pageSize, "select * ", "from blog order by id asc");
    }
}

