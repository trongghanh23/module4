package com.manager_blog.service.impl;

import com.manager_blog.model.Blog;
import com.manager_blog.repository.IBlogRepository;
import com.manager_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findGetId(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }


}
