package money.calculator.MoneyCalculator.entity;


import lombok.Data;
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
    private boolean employed;
    private boolean married;
    private int salary;
    private int period;
    private double percents;
    private double totalSum;

    public Deposit() {

    }




    public Deposit(String name, Sex sex, int age, int sum, boolean employed, boolean married, int salary, int period, double percents, double totalSum) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sum = sum;
        this.employed = employed;
        this.married = married;
        this.salary = salary;
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

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
