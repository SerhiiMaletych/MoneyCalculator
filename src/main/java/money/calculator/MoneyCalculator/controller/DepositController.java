package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.Deposit;
import money.calculator.MoneyCalculator.service.DepositService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepositController {
    Deposit deposit = new Deposit();
    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
    @RequestMapping(value = "/deposit")
    public String depositMenu(Model model) {
        model.addAttribute("deposit", deposit);
        return "deposit/deposit-menu";
    }

    @PostMapping(value = "/deposit", params = "calculate")
    public String depositResult(@ModelAttribute("deposit") Deposit deposit, Model model) {
        model.addAttribute("percentsBasedOnMonths", depositService.findPercents(deposit)*100);
        model.addAttribute("percentsFromSum", depositService.calculatePercents(deposit));
        model.addAttribute("result", depositService.calculateDeposit(deposit));
        return "deposit/deposit-menu";
    }

    @PostMapping(value = "/deposit", params = "clear")
    public String clear(@ModelAttribute("deposit") Deposit deposit, Model model) {
        model.addAttribute("deposit", depositService.clear(deposit));
        model.addAttribute("result", 0);
        return "deposit/deposit-menu";
    }


}
