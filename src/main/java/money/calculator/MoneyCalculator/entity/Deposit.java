package money.calculator.MoneyCalculator.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Deposit {

    @javax.persistence.Id
    private Long Id;

    public Deposit(String name, double sum, int age, boolean employed, boolean married, int salary, int period, double percents, double totalSum) {
        this.name = name;
        this.sum = sum;
        this.age = age;
        this.employed = employed;
        this.married = married;
        this.salary = salary;
        this.period = period;
        this.percents = percents;
        this.totalSum = totalSum;
    }

    private String name;
    private double sum;
    private int age;
    private boolean employed;
    private boolean married;
    private int salary;
    private int period;
    private double percents;
    private double totalSum;
}
