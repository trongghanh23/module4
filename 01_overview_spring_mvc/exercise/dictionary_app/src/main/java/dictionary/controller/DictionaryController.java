package dictionary.controller;

import dictionary.repository.IDictionaryRepository;
import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String formConvert() {
        return ("/dictionary");
    }

    @PostMapping("/search")
    public String search(@RequestParam String language, Model model) {
        String result = iDictionaryService.convert(language);
        model.addAttribute("result", result);
        return ("/dictionary");
    }

}


