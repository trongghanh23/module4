package com.codegym.product.controller;

import com.codegym.product.model.Cart;
import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        Iterable<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        return"shop";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("product") Product product,
                          RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Register success!");
        return "redirect:/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam Integer id, Model model){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()){
            model.addAttribute("product", productOptional.get());
            return "detail";
        }
        return "error.404";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        this.productService.remove(id);
        return "redirect:/shop";
    }
}