package manager_spice.controller;

import manager_spice.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpiceController {
    @Autowired
    private ISpiceService iSpiceService;

    @GetMapping("/")
    public String chooseSpice(Model model) {
        List<String> listSpice = iSpiceService.chooseSpiceSandwich();

        model.addAttribute("listSpice", listSpice);
        return ("/form_spice");

    }

    @PostMapping("/save")
    public String save(@RequestParam String[] spice, Model model) {
        List<String> listSpice = iSpiceService.chooseSpiceSandwich();
        model.addAttribute("listSpice", listSpice);

        model.addAttribute("spice", spice);

        return ("/form_spice");

    }
}
