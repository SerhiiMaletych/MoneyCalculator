package money.calculator.MoneyCalculator.entity;

import lombok.Data;
import money.calculator.MoneyCalculator.model.*;
import money.calculator.MoneyCalculator.model.credit.Conviction;
import money.calculator.MoneyCalculator.model.credit.CreditResult;

import javax.persistence.Entity;


@Data
@Entity
public class Credit {


    @javax.persistence.Id
    private Long Id;
    private String name;
    private Sex sex;
    private Employed employed;
    private Conviction conviction;
    private Married married;
    private int age;
    private int sum;
    private int salary;
    private int period;
    private CreditResult creditResult;
    private double percents;
    private double credit;



    public Credit(String name, Sex sex, Employed employed, Conviction conviction,
                  Married married, int age, int sum, int salary, int period,
                  CreditResult creditResult, double percents, double credit) {
        this.name = name;
        this.sex = sex;
        this.employed = employed;
        this.conviction = conviction;
        this.married = married;
        this.age = age;
        this.sum = sum;
        this.salary = salary;
        this.period = period;
        this.creditResult = creditResult;
        this.percents = percents;
        this.credit = credit;
    }



}
