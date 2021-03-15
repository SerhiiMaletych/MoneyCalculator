package money.calculator.MoneyCalculator.entity.insurance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.CarModel;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private int age;
    private CarModel carModel;
    private double carEngine;
    private int yearOfProduction;
    private int driverExperience;
    private boolean isTaxi;
    private Result result;
    private int insurancePayment;

    public Car(String name, int age, CarModel carModel, double carEngine, int yearOfProduction, int driverExperience, boolean isTaxi, Result result, int insurancePayment) {
        this.name = name;
        this.age = age;
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.yearOfProduction = yearOfProduction;
        this.driverExperience = driverExperience;
        this.isTaxi = isTaxi;
        this.result = result;
        this.insurancePayment = insurancePayment;
    }

}
