package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.Deposit;
import money.calculator.MoneyCalculator.service.DepositService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="deposit")
public class DepositController {
    Deposit deposit = new Deposit();
    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
    @RequestMapping(value = "/")
    public String depositMenu(Model model) {
        model.addAttribute("deposit", deposit);
        return "deposit/deposit-menu";
    }

    @PostMapping(value = "/", params = "add")
    public String depositResult(@ModelAttribute("deposit") Deposit deposit, Model model) {
        model.addAttribute("deposit", depositService.calculateDeposit(deposit));
        return "deposit/deposit-menu";
    }


}
