package save_email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import save_email.model.Email;
import save_email.service.IEmailService;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public String goEmail(Model model) {

        model.addAttribute("email", new Email());

        List<String> language = iEmailService.language();
        model.addAttribute("language", language);

        List<String> size = iEmailService.size();
        model.addAttribute("size", size);
        return "/email";
    }

    @PostMapping("/email")
    public String email(Model model, @ModelAttribute Email email) {
        model.addAttribute("email", email);
        return ("/list");
    }


}
