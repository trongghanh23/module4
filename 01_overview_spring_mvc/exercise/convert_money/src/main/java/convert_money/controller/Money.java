package convert_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Money {
    @GetMapping("/")
    public String formConvert() {
        return "money";
    }

    @PostMapping("/convert/money/vn")
    public String convertMoney(@RequestParam double usd, Model model) {
        double result = usd * 23000;
        model.addAttribute("result", result);
        return "money";
    }
}



