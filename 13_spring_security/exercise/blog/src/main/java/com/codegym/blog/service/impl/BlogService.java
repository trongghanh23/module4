package com.codegym.blog.service.impl;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.Category;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return this.iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> getAllBlog(String searchValue, Pageable pageable) {
        return this.iBlogRepository.getAllBlog("%" + searchValue + "%", pageable);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.delete(this.iBlogRepository.getById(id));
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return iBlogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

}