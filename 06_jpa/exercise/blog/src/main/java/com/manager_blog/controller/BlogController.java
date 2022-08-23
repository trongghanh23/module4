package com.manager_blog.controller;

import com.manager_blog.model.Blog;
import com.manager_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String listBlog(Model model) {
        List<Blog> blogList = this.iBlogService.findAllBlog();
        model.addAttribute("blogList", blogList);
        return "/list";

    }

    @GetMapping("/blog/create")
    public String create(Model model) {
        model.addAttribute("Blog", new Blog());
        return "/create";
    }

    @PostMapping("/blog/save")
    public String saveCreate(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Register successfully");
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findGetId(id));
        return "/edit";
    }

    @PostMapping("/blog/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findGetId(id));
        return "/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iBlogService.remove(id);
        return "redirect:/";
    }
}
