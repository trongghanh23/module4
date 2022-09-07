package com.codegym.blog.service.impl;


import com.codegym.blog.entity.Category;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return this.iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        this.iCategoryRepository.delete(this.iCategoryRepository.getById(id));
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.iCategoryRepository.findAll(pageable);
    }
}