package money.calculator.MoneyCalculator.insurance;


import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.AmateurSport;
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
    public void testTotalCalculationOfLifeInsurance() {
        Life life = new Life("Kira", 49, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life1 = new Life("Kira", 43, 180, 120, Employed.YES,
                Job.FACTORY_WORKER, Sickness.HEADACHE, AmateurSport.YES, ProSport.NONE);
        Life life2 = new Life("Kira", 19, 160, 44, Employed.YES,
                Job.FIREFIGHTER, Sickness.NONE, AmateurSport.YES, ProSport.ARCHERY);
        Life life3 = new Life("Kira", 26, 10, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life4 = new Life("", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.NONE);

        assertEquals(lifeService.calculateLifeInsurancePayment(life), 132.0);
        assertEquals(lifeService.calculateLifeInsurancePayment(life1), 188.76000000000005);
        assertEquals(lifeService.calculateLifeInsurancePayment(life2), 237.60000000000002);
        assertEquals(lifeService.calculateLifeInsurancePayment(life3), 0);
        assertEquals(lifeService.calculateLifeInsurancePayment(life4), 0);


    }
    @Test
    public void testProfessionalSportMultipliers() {
        Life life = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life1 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.ATHLETICS);
        Life life2 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.RUNNING);
        Life life3 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.DIVING);
        Life life4 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.GYMNASTICS);
        Life life5 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.TENNIS);
        Life life6 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.BOXING);
        Life life7 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.POWERLIFTING);
        Life life8 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.FENCING);
        Life life9 = new Life("Lucy", 20, 165, 53, Employed.YES,
                Job.HAIRDRESSER, Sickness.NONE, AmateurSport.YES, ProSport.CROSSFIT);
        assertEquals(lifeService.findProSportMultiplier(life),1);
        assertEquals(lifeService.findProSportMultiplier(life1),1.2);
        assertEquals(lifeService.findProSportMultiplier(life2), 1.2);
        assertEquals(lifeService.findProSportMultiplier(life3),1.4);
        assertEquals(lifeService.findProSportMultiplier(life4),1.4);
        assertEquals(lifeService.findProSportMultiplier(life5),1.4);
        assertEquals(lifeService.findProSportMultiplier(life6),1.6);
        assertEquals(lifeService.findProSportMultiplier(life7),1.6);
        assertEquals(lifeService.findProSportMultiplier(life8),1.6);
        assertEquals(lifeService.findProSportMultiplier(life9),1.7);

    }
    @Test
    public void testAllJobMultipliers() {
        Life life = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.ARCHITECT, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life1 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.LAWYER, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life2 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.DOCTOR, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life3 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.CLEANER, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life4 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.BUTCHER, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life5 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.MECHANIC, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life6 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.BUILDER, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life7 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.ELECTRICIAN, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life8 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.FIREFIGHTER, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        Life life9 = new Life("Kevin", 22, 170, 72, Employed.YES,
                Job.POLITICIAN, Sickness.NONE, AmateurSport.YES, ProSport.KARATE);
        assertEquals(lifeService.findJobMultiplier(life),1);
        assertEquals(lifeService.findJobMultiplier(life1),1);
        assertEquals(lifeService.findJobMultiplier(life2),1.2);
        assertEquals(lifeService.findJobMultiplier(life3),1.2);
        assertEquals(lifeService.findJobMultiplier(life4),1.3);
        assertEquals(lifeService.findJobMultiplier(life5),1.3);
        assertEquals(lifeService.findJobMultiplier(life6),1.4);
        assertEquals(lifeService.findJobMultiplier(life7),1.4);
        assertEquals(lifeService.findJobMultiplier(life8),1.5);
        assertEquals(lifeService.findJobMultiplier(life9),1.7);
    }
    @Test
    public void testAllSicknessesMultipliers() {
        Life life = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life1 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.HEADACHE, AmateurSport.YES, ProSport.NONE);
        Life life2 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.DIABETES, AmateurSport.YES, ProSport.NONE);
        Life life3 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.PULMONARY, AmateurSport.YES, ProSport.NONE);
        Life life4 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.STROKE, AmateurSport.YES, ProSport.NONE);
        Life life5 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.CIRRHOSIS, AmateurSport.YES, ProSport.NONE);
        Life life6 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.CANCER, AmateurSport.YES, ProSport.NONE);

        assertEquals(lifeService.findSicknessMultiplier(life), 1);
        assertEquals(lifeService.findSicknessMultiplier(life1), 1.1);
        assertEquals(lifeService.findSicknessMultiplier(life2), 1.2);
        assertEquals(lifeService.findSicknessMultiplier(life3), 1.3);
        assertEquals(lifeService.findSicknessMultiplier(life4),1.4);
        assertEquals(lifeService.findSicknessMultiplier(life5), 1.5);
        assertEquals(lifeService.findSicknessMultiplier(life6), 2);


    }
    @Test
    public void testAmateurSport() {
        Life life = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life1 = new Life("Jason", 30, 170, 73, Employed.YES,
                Job.NONE, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        assertEquals(lifeService.findAmateurSportMultiplier(life), 1.2);
        assertEquals(lifeService.findAmateurSportMultiplier(life1), 1);

    }
    @Test
    public void testAgeMultiplicationMethod() {
        Life life = new Life("Kate", 0, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life1 = new Life("Kate", -1, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life2 = new Life("Kate", 54, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life3 = new Life("Kate", 65, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life4 = new Life("Kate", 86, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life5 = new Life("Kate", 30, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
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
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life1 = new Life("Kevin", 40, 180, 105, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life2 = new Life("Kevin", 40, 180, 65, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life3 = new Life("Kevin", 40, 100, 35, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life4 = new Life("Kevin", 40, 190, 65, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life5 = new Life("Kevin", 40, 180, 130, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life6 = new Life("Kevin", 40, 0, 130, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life7 = new Life("Kevin", 40, 120, 0, Employed.YES,
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);

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
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        Life life1 = new Life("Kate", 50, 180, 70, Employed.YES,
                Job.ACCOUNTANT, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life2 = new Life("John", 0, 30, 3, Employed.NO,
                Job.NONE, Sickness.NONE, AmateurSport.NO, ProSport.NONE);
        Life life3 = new Life("Brian", 130, 160, 73, Employed.NO,
                Job.NONE, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
        Life life4 = new Life("", 30, 150, 73, Employed.NO,
                Job.NONE, Sickness.NONE, AmateurSport.YES, ProSport.NONE);
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
                Job.ACTOR, Sickness.HEADACHE, AmateurSport.YES, ProSport.BASKETBALL);
        lifeService.clear(life);
        assertEquals(life.getName(), "");
        assertEquals(life.getAge(), 0);
        assertEquals(life.getHeight(), 0);
        assertEquals(life.getEmployed(), Employed.NO);
        assertEquals(life.getJob(), Job.NONE);
        assertEquals(life.getSickness(), Sickness.NONE);
        assertEquals(life.getAmateurSport(), AmateurSport.NO);
        assertEquals(life.getProSport(), ProSport.NONE);

    }
}
