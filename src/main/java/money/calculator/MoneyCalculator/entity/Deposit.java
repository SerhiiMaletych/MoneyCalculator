package money.calculator.MoneyCalculator.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Married;
import money.calculator.MoneyCalculator.model.Sex;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Deposit {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private Sex sex;
    private int age;
    private int sum;
    private Employed employed;
    private Married married;
    private int period;
    private double percents;
    private double totalSum;

    public Deposit(int sum, int period) {
        this.sum = sum;
        this.period = period;
    }


    public Deposit(int sum, int period, double percents) {
        this.sum = sum;
        this.period = period;
        this.percents = percents;
    }

    public Deposit(String name, Sex sex, int age, int sum, Employed employed, int period, double percents, double totalSum, Married married) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sum = sum;
        this.employed = employed;
        this.married = married;
        this.period = period;
        this.percents = percents;
        this.totalSum = totalSum;
    }

    public double setPercents(double percents) {
        this.percents = percents;
        return percents;
    }


}
