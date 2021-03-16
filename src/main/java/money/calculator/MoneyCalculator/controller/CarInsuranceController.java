package money.calculator.MoneyCalculator.controller;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.service.insurance.CarInsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarInsuranceController {

    Car car = new Car();
    private final CarInsuranceService carInsuranceService;

    public CarInsuranceController(CarInsuranceService carInsuranceService) {
        this.carInsuranceService = carInsuranceService;
    }

    @RequestMapping("/car")
    public String carInsuranceMenu(Model model) {
        model.addAttribute("car", car);
        return "insurance/car-insurance-menu";
    }

    @PostMapping(value = "/car", params = "calculate")
    public String carInsuranceResult(@ModelAttribute("car") Car car, Model model) {
        model.addAttribute("result", carInsuranceService.doInsuranceResult(car));
        return "insurance/car-insurance-menu";
    }


    @PostMapping(value = "/car", params = "clear")
    public String clear(@ModelAttribute("car") Car Car, Model model) {
        model.addAttribute("car", carInsuranceService.clear(car));
        model.addAttribute("result", 0);
        return "insurance/car-insurance-menu";
    }
}
