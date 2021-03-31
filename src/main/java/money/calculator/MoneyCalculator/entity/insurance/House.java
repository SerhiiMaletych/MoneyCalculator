package money.calculator.MoneyCalculator.entity.insurance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import money.calculator.MoneyCalculator.model.Result;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private int housePrice;
    private int houseArea;
    private int yearOfConstruction;
    private Result result;
    private int insurancePayment;

    public House(String name, int housePrice, int houseArea, int yearOfConstruction,
                 Result result, int insurancePayment) {
        this.name = name;
        this.housePrice = housePrice;
        this.houseArea = houseArea;
        this.yearOfConstruction = yearOfConstruction;
        this.result = result;
        this.insurancePayment = insurancePayment;
    }

    public House(String name, int housePrice, int houseArea, int yearOfConstruction) {
        this.name = name;
        this.housePrice = housePrice;
        this.houseArea = houseArea;
        this.yearOfConstruction = yearOfConstruction;
    }
}
