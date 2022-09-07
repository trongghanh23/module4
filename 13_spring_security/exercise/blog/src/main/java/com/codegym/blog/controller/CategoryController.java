package com.codegym.blog.controller;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/category")
    public ModelAndView listCategory() {
        Iterable<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Category> category = iCategoryService.findById(id);
        ModelAndView modelAndView;
        if (category.isPresent()) {
            modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Optional<Category> category = iCategoryService.findById(id);
        ModelAndView modelAndView;
        if (category.isPresent()) {
            modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category.get());

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        iCategoryService.remove(category.getId());
        return "redirect:category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Integer id) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = iBlogService.findAllByCategory(categoryOptional.get());

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", categoryOptional.get());
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}