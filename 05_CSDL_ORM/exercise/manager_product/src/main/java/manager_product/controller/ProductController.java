package manager_product.controller;

import manager_product.model.Product;
import manager_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String listProduct(Model model,String name) {
        List<Product> productList = iProductService.findAll(name);
        model.addAttribute("productList", productList);
        return "list";

    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("Product", new Product());
        return "/create";
    }

    @PostMapping("/customer/save")
    public String saveCreate(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Register successfully");
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findGetId(id));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product) {
        iProductService.edit(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findGetId(id));
        return "/detail";
    }


    @GetMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

}
