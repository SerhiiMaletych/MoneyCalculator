package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.entity.insurance.House;
import money.calculator.MoneyCalculator.service.insurance.HouseInsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HouseInsuranceController {

    private final HouseInsuranceService houseInsuranceService;
    House house = new House();
    public HouseInsuranceController(HouseInsuranceService houseInsuranceService) {
        this.houseInsuranceService = houseInsuranceService;
    }


    @RequestMapping("/house")
    public String houseInsuranceMenu(Model model) {
        model.addAttribute("house", house);
        return "insurance/house-insurance-menu";
    }

    @PostMapping(value = "/house", params = "calculate")
    public String houseInsuranceResult(@ModelAttribute("house")House house,  Model model) {
        model.addAttribute("result", houseInsuranceService.findInsurancePayment(house));
        return "insurance/house-insurance-menu";
    }


    @PostMapping(value = "/house", params = "clear")
    public String clear(@ModelAttribute("house")House house,  Model model) {
        model.addAttribute("house", houseInsuranceService.clear(house));
        model.addAttribute("result", 0);
        return "insurance/house-insurance-menu";
    }
}
