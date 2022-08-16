package convert_money.controller;

import convert_money.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    private IMoneyService iMoneyService;

    @GetMapping("/")
    public String formConvert() {
        return "/money";
    }

    @PostMapping("/convert/money/vn")
    public String convertMoney(@RequestParam int usd, Model model) {
        int result = iMoneyService.convertMoney(usd);
        model.addAttribute("result", result);
        return "/money";
    }
}



