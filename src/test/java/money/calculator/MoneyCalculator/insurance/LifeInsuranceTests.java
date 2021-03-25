package money.calculator.MoneyCalculator.insurance;


import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.Job;
import money.calculator.MoneyCalculator.model.insurance.ProSport;
import money.calculator.MoneyCalculator.model.insurance.Sickness;
import money.calculator.MoneyCalculator.service.insurance.LifeInsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LifeInsuranceTests {
    @Autowired
    LifeInsuranceService lifeService;


    @Test
    public void testAmateurSport() {
        Life life = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.NONE, true, ProSport.NONE);
        Life life1 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.NONE, false, ProSport.NONE);
        assertEquals(lifeService.findAmateurSportMultiplier(life), 1.2);
        assertEquals(lifeService.findAmateurSportMultiplier(life1), 1);

    }
    @Test
    public void testAgeMultiplicationMethod() {
        Life life = new Life("Kate", 0, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life1 = new Life("Kate", -1, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life2 = new Life("Kate", 54, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life3 = new Life("Kate", 65, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life4 = new Life("Kate", 86, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life5 = new Life("Kate", 30, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        assertEquals(lifeService.findAgeMultiplier(life), 0);
        assertEquals(lifeService.findAgeMultiplier(life1), 0);
        assertEquals(lifeService.findAgeMultiplier(life2), 1.1);
        assertEquals(lifeService.findAgeMultiplier(life3), 1.2);
        assertEquals(lifeService.findAgeMultiplier(life4), 1.4);
        assertEquals(lifeService.findAgeMultiplier(life5), 1);


    }

    @Test
    public void testBodyMultiplierForDifferentOutputs() {
        Life life = new Life("Kevin", 40, 200, 110, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life1 = new Life("Kevin", 40, 180, 105, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life2 = new Life("Kevin", 40, 180, 65, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life3 = new Life("Kevin", 40, 100, 35, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life4 = new Life("Kevin", 40, 190, 65, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life5 = new Life("Kevin", 40, 180, 130, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life6 = new Life("Kevin", 40, 0, 130, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life7 = new Life("Kevin", 40, 120, 0, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);

        assertEquals(lifeService.findBodyMultiplier(life), 1);
        assertEquals(lifeService.findBodyMultiplier(life1), 1.1);
        assertEquals(lifeService.findBodyMultiplier(life2), 1.1);
        assertEquals(lifeService.findBodyMultiplier(life3), 1.2);
        assertEquals(lifeService.findBodyMultiplier(life4), 1.3);
        assertEquals(lifeService.findBodyMultiplier(life5), 1.5);
        assertEquals(lifeService.findBodyMultiplier(life6), 0);
        assertEquals(lifeService.findBodyMultiplier(life7), 0);


    }

    @Test
    public void testCredentialsForPassing() {
        Life life = new Life("Petya", 40, 200, 100, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        Life life1 = new Life("Kate", 50, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, false, ProSport.NONE);
        Life life2 = new Life("John", 0, 30, 3, Employed.NO,
                Job.NONE, Sickness.NONE, false, ProSport.NONE);
        Life life3 = new Life("Brian", 130, 160, 73, Employed.NO,
                Job.NONE, Sickness.NONE, true, ProSport.NONE);
        Life life4 = new Life("", 30, 150, 73, Employed.NO,
                Job.NONE, Sickness.NONE, true, ProSport.NONE);
        lifeService.checkCredentials(life);
        lifeService.checkCredentials(life1);
        lifeService.checkCredentials(life2);
        lifeService.checkCredentials(life3);
        lifeService.checkCredentials(life4);

        assertEquals(life.getResult(), Result.APPROVE);
        assertEquals(life1.getResult(), Result.APPROVE);
        assertEquals(life2.getResult(), Result.REJECT);
        assertEquals(life3.getResult(), Result.REJECT);
        assertEquals(life4.getResult(), Result.REJECT);


    }

    @Test
    public void testClearMethod() {
        Life life = new Life("Petya", 40, 200, 100, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, true, ProSport.BASKETBALL);
        lifeService.clear(life);
        assertEquals(life.getName(), "");
        assertEquals(life.getAge(), 0);
        assertEquals(life.getHeight(), 0);
        assertEquals(life.getEmployed(), Employed.NO);
        assertEquals(life.getJob(), Job.NONE);
        assertEquals(life.getSickness(), Sickness.NONE);
        assertEquals(life.isAmateurSport(), false);
        assertEquals(life.getProSport(), ProSport.NONE);

    }
}
