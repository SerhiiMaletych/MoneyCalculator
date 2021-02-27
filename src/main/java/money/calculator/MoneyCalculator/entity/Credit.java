package money.calculator.MoneyCalculator.entity;

import lombok.Data;
import money.calculator.MoneyCalculator.model.Conviction;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Sex;

import javax.persistence.Entity;


@Data
@Entity
public class Credit {

    @javax.persistence.Id
    private Long Id;
    private String name;
    private Sex sex;
    private int age;
    private double sum;
    private Employed employed;
    private Conviction conviction;
    private int salary;
    private int period;
    private boolean result;
    private double credit;

    public Credit() {

    }

    public Credit(String name, Sex sex, int age, double sum, Employed employed, Conviction conviction, int salary, int period, boolean result, double credit) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sum = sum;
        this.employed = employed;
        this.conviction = conviction;
        this.salary = salary;
        this.period = period;
        this.result = result;
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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


}
