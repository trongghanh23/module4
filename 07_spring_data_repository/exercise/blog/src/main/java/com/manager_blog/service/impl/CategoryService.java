package com.manager_blog.service.impl;

import com.manager_blog.model.Category;
import com.manager_blog.repository.ICategoryRepository;
import com.manager_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.getAllCategory();
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iCategoryRepository.delete(findById(id));
    }
}