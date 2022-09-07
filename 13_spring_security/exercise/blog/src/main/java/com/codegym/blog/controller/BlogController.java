package com.codegym.blog.controller;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categoryList")
    public Iterable<Category> category() {
        return iCategoryService.findAll();
    }

    @GetMapping("/blog")
    public ModelAndView listBlog(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam("search") Optional<String> search) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = iBlogService.getAllBlog(search.get(), pageable);
        } else {
            blogs = iBlogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("searchValue", search.orElse(""));
        return modelAndView;
    }


    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView;
        if (blog.isPresent()) {
            modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Integer id) {
        this.iBlogService.remove(id);
        return "redirect:blog";
    }
}