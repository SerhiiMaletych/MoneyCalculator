package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.service.insurance.LifeInsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LifeInsuranceController {
    Life life = new Life();

    private final LifeInsuranceService lifeInsuranceService;

    public LifeInsuranceController(LifeInsuranceService lifeInsuranceService) {
        this.lifeInsuranceService = lifeInsuranceService;
    }

    @RequestMapping(value = "/life")
    public String lifeInsuranceMenu(Model model) {
        model.addAttribute("life", life);
        return "insurance/life-insurance-menu";

    }

    @PostMapping(value = "/life", params = "calculate")
    public String lifeInsuranceResult(@ModelAttribute("life") Life life, Model model) {
        model.addAttribute("result", lifeInsuranceService.calculateLifeInsurancePayment(life));
        return "insurance/life-insurance-menu";
    }

    @PostMapping(value = "/life", params = "clear")
    public String clear(@ModelAttribute("life") Life life, Model model) {
        model.addAttribute("life", lifeInsuranceService.clear(life));
        model.addAttribute("result", 0);
        return "insurance/life-insurance-menu";
    }
}

