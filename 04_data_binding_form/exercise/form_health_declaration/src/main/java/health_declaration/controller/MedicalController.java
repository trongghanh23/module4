package health_declaration.controller;

import health_declaration.model.HealthDeclaration;
import health_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String listMedicalDeclaration(Model model) {
        model.addAttribute("medicalDeclaration", iMedicalService.selectAll());
        return "/list";
    }

    @GetMapping("/create")
    public String formMedical(Model model) {
        model.addAttribute("HealthDeclaration", new HealthDeclaration());

        model.addAttribute("birthday", iMedicalService.birthday());

        model.addAttribute("gender", iMedicalService.gender());

        model.addAttribute("country", iMedicalService.country());

        model.addAttribute("day", iMedicalService.day());

        model.addAttribute("month", iMedicalService.month());

        model.addAttribute("year", iMedicalService.year());

        model.addAttribute("vehicle", iMedicalService.vehicle());

        return ("/create");
    }

    @PostMapping("/save")
    public String saveCreate(@ModelAttribute HealthDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.iMedicalService.save(medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Register successfully");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editMedical(@RequestParam String idCard, Model model) {

        model.addAttribute("HealthDeclaration",this.iMedicalService.selectByIdCard(idCard));

        model.addAttribute("birthday",this.iMedicalService.birthday());

        model.addAttribute("gender", this.iMedicalService.gender());

        model.addAttribute("country", this.iMedicalService.country());

        model.addAttribute("day", this.iMedicalService.day());

        model.addAttribute("month", this.iMedicalService.month());

        model.addAttribute("year", this.iMedicalService.year());

        model.addAttribute("vehicle", this.iMedicalService.vehicle());

        return ("/edit");

    }

    @PostMapping("/update")
    public String update(@ModelAttribute HealthDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.iMedicalService.update(medicalDeclaration, String.valueOf(medicalDeclaration.getIdCard()));
        redirectAttributes.addFlashAttribute("message", "Update successful");
        return "redirect:/";
    }
}
