package money.calculator.MoneyCalculator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String mainPage() {
        return "main-page";
    }
}
