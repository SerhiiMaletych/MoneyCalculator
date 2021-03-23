package money.calculator.MoneyCalculator.service.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.*;
import org.springframework.stereotype.Service;

@Service
public class LifeInsuranceService {
    private double bodyMultiplier;
    private double ageMultiplier;
    private double jobMultiplier;
    private double sicknessMultiplier;
    private double amateurSportMultiplier;
    private double proSportMultiplier;

    public void checkCredentials(Life life) {

    }





    public Life clear(Life life) {
        life.setName("");
        life.setAge(0);
        life.setWeight(0);
        life.setHeight(0);
        life.setEmployed(Employed.NO);
        life.setJob(Job.NONE);
        life.setProSport(ProSport.NONE);
        life.setSickness(Sickness.NONE);
        life.setAmateurSport(false);
        return life;
    }


}
