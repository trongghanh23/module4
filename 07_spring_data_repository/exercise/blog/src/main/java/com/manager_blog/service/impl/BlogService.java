package com.manager_blog.service.impl;

import com.manager_blog.model.Blogger;
import com.manager_blog.repository.IBlogRepository;
import com.manager_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blogger> getAllBlog(String searchName , Pageable pageable) {
        return this.blogRepository.getAllBlog("%" + searchName + "%" ,pageable);
    }

    @Override
    public void deleteBlog(int id) {
        this.blogRepository.deleteBlog(id);
    }

    @Override
    public Blogger save(Blogger blogger) {
        return this.blogRepository.save(blogger);
    }


    @Override
    public Blogger getBlogger(int id) {
        return this.blogRepository.getBlogger(id);
    }


}
