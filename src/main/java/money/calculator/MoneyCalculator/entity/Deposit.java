package money.calculator.MoneyCalculator.entity;


import lombok.Data;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Married;
import money.calculator.MoneyCalculator.model.Sex;

import javax.persistence.Entity;


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

    public Deposit() {

    }


    public Deposit(String name, Sex sex, int age, int sum, Employed employed,  int period, double percents, double totalSum) {
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


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Employed isEmployed() {
        return employed;
    }

    public void setEmployed(Employed employed) {
        this.employed = employed;
    }

    public Married isMarried() {
        return married;
    }

    public void setMarried(Married married) {
        this.married = married;
    }


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getPercents() {
        return percents;
    }

    public double setPercents(double percents) {
        this.percents = percents;
        return percents;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }


}
