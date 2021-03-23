package money.calculator.MoneyCalculator.entity.insurance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.Job;
import money.calculator.MoneyCalculator.model.insurance.ProSport;
import money.calculator.MoneyCalculator.model.insurance.Sickness;

import javax.management.relation.RelationSupport;
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
    private Employed employed;
    private money.calculator.MoneyCalculator.model.insurance.Job Job;
    private Sickness sickness;
    private boolean amateurSport;
    private ProSport proSport;
    private int payment;
    private Result result;


    public Life(String name, int age, int height, int weight, boolean employed,
                money.calculator.MoneyCalculator.model.insurance.Job job,
                Sickness sickness, boolean amateurSport, ProSport proSport, int payment, Result result) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.employed = employed;
        Job = job;
        this.sickness = sickness;
        this.amateurSport = amateurSport;
        this.proSport = proSport;
        this.payment = payment;
        this.result = result;
    }
}
