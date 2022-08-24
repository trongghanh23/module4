package com.manager_blog.service;

import com.manager_blog.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blogger> getAllBlog(String searchName, Pageable pageable);

    void deleteBlog(int id);

    Blogger save(Blogger blogger);

    Blogger getBlogger(int id);
}