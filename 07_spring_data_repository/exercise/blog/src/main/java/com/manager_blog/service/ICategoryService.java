package com.manager_blog.service;


import com.manager_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category save(Category category);

    Category findById(int id);

    void delete(int id);
}