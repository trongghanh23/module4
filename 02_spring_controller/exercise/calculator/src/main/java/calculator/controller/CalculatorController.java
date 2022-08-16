package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String formCalculator() {
        return ("/calculator");
    }

    @GetMapping("/calculators")
    public String calculator(@RequestParam double number1, double number2, String operator, Model model) {
        String result;
        result = iCalculatorService.calculator(number1, number2, operator);
        model.addAttribute("result", result);
        return ("/calculator");


    }
}
