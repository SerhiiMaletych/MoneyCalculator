package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.entity.Deposit;
import money.calculator.MoneyCalculator.service.CreditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }


    @PostMapping(value = "/credit", params = "clear")
    public String clear(@ModelAttribute("deposit") Credit credit , Model model) {
        model.addAttribute("credit", creditService.clear(credit));
        model.addAttribute("result", 0);
        return "credit/credit-menu";
    }
}
