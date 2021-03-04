package money.calculator.MoneyCalculator.entity;

import lombok.Data;
import money.calculator.MoneyCalculator.model.*;

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
    private double sum;
    private int salary;
    private int period;
    private CreditResult creditResult;
    private double percents;
    private double credit;

    public Credit() {

    }


    public Credit(String name, Sex sex, Employed employed, Conviction conviction,
                  Married married, int age, double sum, int salary, int period,
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

    public Employed getEmployed() {
        return employed;
    }

    public void setEmployed(Employed employed) {
        this.employed = employed;
    }

    public Conviction getConviction() {
        return conviction;
    }

    public void setConviction(Conviction conviction) {
        this.conviction = conviction;
    }

    public Married getMarried() {
        return married;
    }

    public void setMarried(Married married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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

    public CreditResult getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(CreditResult creditResult) {
        this.creditResult = creditResult;
    }


    public double getPercents() {
        return percents;
    }

    public void setPercents(double percents) {
        this.percents = percents;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


}
