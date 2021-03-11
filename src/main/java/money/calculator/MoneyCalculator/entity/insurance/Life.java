package money.calculator.MoneyCalculator.entity.insurance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import money.calculator.MoneyCalculator.model.Married;
import money.calculator.MoneyCalculator.model.insurance.Job;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Life {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private int age;
    private int height;
    private int weight;
    private money.calculator.MoneyCalculator.model.insurance.Job Job;
    private boolean isSick;
    private int payment;
    private int insurance;

    public Life(String name, int age, int height, int weight,
                money.calculator.MoneyCalculator.model.insurance.Job job,
                boolean isSick, int payment, int insurance) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        Job = job;
        this.isSick = isSick;
        this.payment = payment;
        this.insurance = insurance;
    }
}
