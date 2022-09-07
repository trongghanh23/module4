package com.codegym.blog.service;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);

    Iterable<Blog> findAllByCategory(Category category);

    Blog save(Blog blog);

    Page<Blog> getAllBlog(String searchValue, Pageable pageable);
}