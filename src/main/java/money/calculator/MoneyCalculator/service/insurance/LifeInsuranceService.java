package money.calculator.MoneyCalculator.service.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.AmateurSport;
import money.calculator.MoneyCalculator.model.insurance.Job;
import money.calculator.MoneyCalculator.model.insurance.ProSport;
import money.calculator.MoneyCalculator.model.insurance.Sickness;
import org.springframework.stereotype.Service;

@Service
public class LifeInsuranceService {
    private double bodyMultiplier;
    private double ageMultiplier;
    private double jobMultiplier;
    private double sicknessMultiplier;
    private double amateurSportMultiplier;
    private double proSportMultiplier;


    public double calculateLifeInsurancePayment(Life life) {
        double basePayment = 100;
        checkCredentials(life);
        findBodyMultiplier(life);
        findAgeMultiplier(life);
        findAmateurSportMultiplier(life);
        findSicknessMultiplier(life);
        findJobMultiplier(life);
        findProSportMultiplier(life);
        if(life.getResult()==Result.APPROVE) {

        return basePayment * bodyMultiplier * ageMultiplier * jobMultiplier * sicknessMultiplier *
                amateurSportMultiplier * proSportMultiplier;
        }
        else return 0;
    }

    public double findProSportMultiplier(Life life) {
        if (life.getProSport() == ProSport.NONE || life.getProSport() == ProSport.CHESS) {
            return proSportMultiplier = 1;
        } else if (life.getProSport() == ProSport.ATHLETICS || life.getProSport() == ProSport.ARCHERY ||
                life.getProSport() == ProSport.BADMINTON || life.getProSport() == ProSport.GOLF ||
                life.getProSport() == ProSport.RUNNING) {
            return proSportMultiplier = 1.2;
        } else if (life.getProSport() == ProSport.BASKETBALL || life.getProSport() == ProSport.DIVING ||
                life.getProSport() == ProSport.FOOTBALL || life.getProSport() == ProSport.GYMNASTICS ||
                life.getProSport() == ProSport.SKIING || life.getProSport() == ProSport.TENNIS ||
                life.getProSport() == ProSport.TRIATHLON) {
            return proSportMultiplier = 1.4;
        } else if (life.getProSport() == ProSport.BOXING || life.getProSport() == ProSport.HOCKEY ||
                life.getProSport() == ProSport.FENCING || life.getProSport() == ProSport.KARATE ||
                life.getProSport() == ProSport.RUGBY || life.getProSport() == ProSport.POWERLIFTING ||
                life.getProSport() == ProSport.WEIGHTLIFTING) {
            return proSportMultiplier = 1.6;
        } else if (life.getProSport() == ProSport.CROSSFIT) {
            return proSportMultiplier = 1.7;
        } else return 0;
    }

    public double findJobMultiplier(Life life) {
        if (life.getJob() == Job.NONE || life.getJob() == Job.ARCHITECT || life.getJob() == Job.ACCOUNTANT ||
                life.getJob() == Job.AUTHOR || life.getJob() == Job.HAIRDRESSER || life.getJob() == Job.LAWYER
                || life.getJob() == Job.MODEL || life.getJob() == Job.TEACHER || life.getJob() == Job.WAITER) {
            return jobMultiplier = 1;
        } else if (life.getJob() == Job.ACTOR || life.getJob() == Job.DOCTOR || life.getJob() == Job.CLEANER
                || life.getJob() == Job.FARMER || life.getJob() == Job.BAKER) {
            return jobMultiplier = 1.2;
        } else if (life.getJob() == Job.BUTCHER || life.getJob() == Job.DRIVER || life.getJob() == Job.FACTORY_WORKER
                || life.getJob() == Job.MECHANIC) {
            return jobMultiplier = 1.3;
        } else if (life.getJob() == Job.BUILDER || life.getJob() == Job.ELECTRICIAN) {
            return jobMultiplier = 1.4;
        } else if (life.getJob() == Job.FIREFIGHTER || life.getJob() == Job.POLICEMAN) {
            return jobMultiplier = 1.5;
        } else if (life.getJob() == Job.PILOT || life.getJob() == Job.POLITICIAN || life.getJob() == Job.SOLDIER) {
            return jobMultiplier = 1.7;
        } else return 0;
    }

    public double findSicknessMultiplier(Life life) {
        if (life.getSickness() == Sickness.NONE) {
            return sicknessMultiplier = 1;
        } else if (life.getSickness() == Sickness.HEADACHE) {
            return sicknessMultiplier = 1.1;
        } else if (life.getSickness() == Sickness.DIABETES || life.getSickness() == Sickness.DIARRHEAL) {
            return sicknessMultiplier = 1.2;
        } else if (life.getSickness() == Sickness.PULMONARY || life.getSickness() == Sickness.DEMENTIAS) {
            return sicknessMultiplier = 1.3;
        } else if (life.getSickness() == Sickness.STROKE || life.getSickness() == Sickness.TUBERCULOSIS) {
            return sicknessMultiplier = 1.4;
        } else if (life.getSickness() == Sickness.CIRRHOSIS || life.getSickness() == Sickness.HEART) {
            return sicknessMultiplier = 1.5;
        } else if (life.getSickness() == Sickness.CANCER) {
            return sicknessMultiplier = 2;
        } else return 0;
    }

    public double findAmateurSportMultiplier(Life life) {
        if (life.getAmateurSport()== AmateurSport.YES) {
            return amateurSportMultiplier = 1.2;
        } else return amateurSportMultiplier = 1;
    }

    public double findAgeMultiplier(Life life) {
        if(life.getAge()==0 || life.getAge()<0) {
            return ageMultiplier =0;
        }
        else if (life.getAge() > 50 && life.getAge() < 60) {
            return ageMultiplier = 1.1;
        } else if (life.getAge() > 60 && life.getAge() < 70) {
            return ageMultiplier = 1.2;
        } else if (life.getAge() > 70 && life.getAge() < 100) {
            return ageMultiplier = 1.4;
        } else if (life.getAge() > 0 && life.getAge() < 50) {
            return ageMultiplier = 1;
        } else return 0;
    }

    public double findBodyMultiplier(Life life) {
        double bodyVariable = life.getHeight() - life.getWeight();
        if( life.getHeight()==0 || life.getWeight()==0) {
            return bodyMultiplier = 0;
        }
        else if (bodyVariable > 80 && bodyVariable < 110) {
            return bodyMultiplier = 1;
        } else if (bodyVariable > 70 && bodyVariable < 80) {
            return bodyMultiplier = 1.1;
        } else if (bodyVariable > 110 && bodyVariable < 120) {
            return bodyMultiplier = 1.1;
        } else if (bodyVariable > 60 && bodyVariable < 70) {
            return bodyMultiplier = 1.2;
        } else if (bodyVariable > 120 && bodyVariable < 130) {
            return bodyMultiplier = 1.3;
        } else if (bodyVariable < 60 || bodyVariable > 130) {
            return bodyMultiplier = 1.5;
        }

        else return 0;

    }

    public void checkCredentials(Life life) {
        if (life.getName().isEmpty() || life.getName().isBlank() || life.getAge() < 0 || life.getAge() > 100
                || life.getWeight() < 2 || life.getWeight() > 200 || life.getHeight() < 40 || life.getHeight() > 270
        ) {
            life.setResult(Result.REJECT);
        } else life.setResult(Result.APPROVE);
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
        life.setAmateurSport(AmateurSport.NO);
        return life;
    }


}
