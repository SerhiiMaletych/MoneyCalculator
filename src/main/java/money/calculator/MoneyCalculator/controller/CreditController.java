package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.service.CreditService;
import org.springframework.stereotype.Controller;

@Controller
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }
}
