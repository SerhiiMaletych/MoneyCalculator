package money.calculator.MoneyCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Credit {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private double sum;
    private int age;
    private boolean employed;
    private boolean conviction;
    private int salary;
    private int period;
    private boolean result;
    private double credit;

    public Credit() {

    }

    public Credit(double sum, int age, boolean employed, boolean conviction, int salary, int period, boolean result, double credit) {
        this.sum = sum;
        this.age = age;
        this.employed = employed;
        this.conviction = conviction;
        this.salary = salary;
        this.period = period;
        this.result = result;
        this.credit = credit;
    }


}
