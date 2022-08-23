package com.manager_blog.service;

import com.manager_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllBlog();

    Blog findGetId(Integer id);

    void save(Blog blog);

    void remove(int id);


}
