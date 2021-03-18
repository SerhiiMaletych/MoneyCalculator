package money.calculator.MoneyCalculator.service;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Married;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.Sex;
import money.calculator.MoneyCalculator.model.credit.Conviction;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    public void findCreditSum(Credit credit) {
        checkCredentials(credit);
        checkSalary(credit);
//        findCreditResult(credit);
        if (credit.getResult() == Result.APPROVE) {
            checkConviction(credit);
        }
    }

//    public void findCreditResult(Credit credit) {
//        var division = credit.getSum() / credit.getSalary();
//
//        if (division < 10) {
//             credit.setResult(Result.APPROVE);
//        }
//        else credit.setResult(Result.REJECT);
//    }


    public void checkCredentials(Credit credit) {
        if (credit.getName().isEmpty() || credit.getAge() < 18 || credit.getAge() > 90 ||
                credit.getSalary() < 100 || credit.getEmployed() == Employed.NO) {
            credit.setResult(Result.REJECT);
        }
    }


    public void checkConviction(Credit credit) {
        if (credit.getConviction() == Conviction.NO) {
            credit.setPercents(credit.getPercents() + 0.01);
        }
    }


    public double calculatePercents(Credit credit) {
        findPercents(credit);
        checkConviction(credit);
        return credit.getSum() * credit.getPercents() * credit.getPeriod() / 12;

    }


    public void findPercents(Credit credit) {


       if (credit.getSum() / credit.getSalary() < 3 && credit.getPeriod() <= 6) {
            credit.setPercents(0.09);
    } else if (credit.getSum() / credit.getSalary() < 4 && credit.getPeriod() <= 7) {
        credit.setPercents(0.1);
    } else if (credit.getSum() / credit.getSalary() < 5 && credit.getPeriod() <= 8) {
        credit.setPercents(0.11);
       }
        else if (credit.getSum() / credit.getSalary() < 6 && credit.getPeriod() <= 9) {
            credit.setPercents(0.12);
        } else credit.setPercents(0.13);

    }

    public void checkSalary(Credit credit) {
        if (credit.getSalary() < 3000) {
            credit.setResult(Result.REJECT);
        } else credit.setResult(Result.APPROVE);
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
