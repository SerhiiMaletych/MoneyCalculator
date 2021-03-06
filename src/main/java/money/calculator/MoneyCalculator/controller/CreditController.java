package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.service.CreditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreditController {

    Credit credit = new Credit();
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @RequestMapping(value = "/credit")
    public String creditMenu(Model model) {
        model.addAttribute("credit", credit);
        return "credit/credit-menu";
    }

    @PostMapping(value = "/credit", params = "calculate")
    public String creditResult(@ModelAttribute("credit") Credit credit, Model model, BindingResult bindingResult) {
        model.addAttribute("percents", creditService.findPercentsForCredit(credit));
        model.addAttribute("percentsFromSum", creditService.calculateAmountOfPercentPayment(credit));
        model.addAttribute("creditSum", creditService.findCreditSum(credit));
        model.addAttribute("monthPayment", creditService.findMonthPayment(credit));

        return "credit/credit-menu";
    }


    @PostMapping(value = "/credit", params = "clear")
    public String clear(@ModelAttribute("credit") Credit credit, Model model) {
        model.addAttribute("credit", creditService.clear(credit));
        model.addAttribute("result", 0);
        return "credit/credit-menu";
    }
}
