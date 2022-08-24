package com.manager_blog.controller;

import com.manager_blog.model.Blogger;
import com.manager_blog.service.IBlogService;
import com.manager_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bloggers")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String displayBlog(Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> search){
        String searchName = search.orElse("");
        model.addAttribute("searchName",searchName);
        model.addAttribute("blogList", this.iBlogService.getAllBlog(searchName,pageable));
        return "list";
    }
    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blogger());
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "create";
    }
    @PostMapping("/create")
    public String saveBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers";
    }
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",iBlogService.getBlogger(id));
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "edit";
    }
    @PostMapping("/edit")
    public String updateBlog(Blogger blogger){
        this.iBlogService.save(blogger);
        return "redirect:/bloggers";
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id){
        this.iBlogService.deleteBlog(id);
        return "redirect:/bloggers";
    }
    @GetMapping("/details/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blog",this.iBlogService.getBlogger(id) );
        return "details";
    }
}