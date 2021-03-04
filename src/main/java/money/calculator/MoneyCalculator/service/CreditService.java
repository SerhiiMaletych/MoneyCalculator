package money.calculator.MoneyCalculator.service;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.*;
import org.springframework.stereotype.Service;

@Service
public class CreditService {


    public void checkCredentials(Credit credit) {
        if (credit.getName().isEmpty() || credit.getAge() < 18 || credit.getAge() > 90 ||
                credit.getSalary() < 100) {
            credit.setCreditResult(CreditResult.REJECT);
        }
    }

    public void findPercents(Credit credit) {
        if(credit.getSalary()>2000){
            if(credit.getSum()/credit.getSalary()<6 && credit.getPeriod()<=6){
                credit.setCreditResult(CreditResult.APPROVE);
                credit.setPercents(12);
            }
            else if(credit.getSum()/credit.getSalary()<5 && credit.getPeriod()<=7){
                credit.setCreditResult(CreditResult.APPROVE);
                credit.setPercents(11);
            }
        }
    }


    public Credit clear(Credit credit) {
        credit.setName("0");
        credit.setSum(0);
        credit.setAge(0);
        credit.setConviction(Conviction.NO);
        credit.setEmployed(Employed.NO);
        credit.setSex(Sex.NONE);
        credit.setSalary(0);
        credit.setMarried(Married.NO);

        return credit;
    }

}
