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

    public double findMonthPayment(Credit credit) {
        return findCreditSum(credit) / credit.getPeriod();
    }

    public double findCreditSum(Credit credit) {
        checkCredentials(credit);
        checkSalary(credit);
        findCreditResult(credit);
        if(credit.getResult()==Result.APPROVE){
        return  credit.getSum() + calculateAmountOfPercentPayment(credit);
        }

        return 0;
    }

    public double calculateAmountOfPercentPayment(Credit credit) {
        findPercentsForCredit(credit);
        checkConviction(credit);
        findCreditResult(credit);
        if(credit.getResult()==Result.APPROVE) {
            return credit.getSum() * credit.getPercents() * credit.getPeriod() / 12;
        }
        else return 0;
    }

    public double findPercentsForCredit(Credit credit) {

        if (credit.getSum() / credit.getSalary() < 3 && credit.getPeriod() <= 6) {
            credit.setPercents(0.09);
            return credit.getPercents()*100;
        } else if (credit.getSum() / credit.getSalary() < 4 && credit.getPeriod() <= 7) {
            credit.setPercents(0.1);
            return credit.getPercents()*100;
        } else if (credit.getSum() / credit.getSalary() < 5 && credit.getPeriod() <= 8) {
            credit.setPercents(0.11);
            return credit.getPercents()*100;
        } else if (credit.getSum() / credit.getSalary() < 6 && credit.getPeriod() <= 9) {
            credit.setPercents(0.12);
            return credit.getPercents()*100;
        } else if (credit.getSum() / credit.getSalary() < 12 && credit.getPeriod() <= 24)
            credit.setPercents(0.13);
        return credit.getPercents()*100;

    }


    public void findCreditResult(Credit credit) {
        var division = credit.getSum() / credit.getSalary();
        if (division <= 10 && division != 0 || credit.getSalary()>=credit.getSum()) {
            credit.setResult(Result.APPROVE);
        } else credit.setResult(Result.REJECT);
    }


    public void checkCredentials(Credit credit) {

        if (credit.getName().isEmpty() || credit.getAge() < 18 || credit.getAge() > 90 ||
                credit.getSalary() < 1000 || credit.getEmployed() == Employed.NO) {
            credit.setResult(Result.REJECT);
        } else credit.setResult(Result.APPROVE);
    }

    public void checkConviction(Credit credit) {
        if (credit.getConviction() == Conviction.NO) {
            credit.setPercents(credit.getPercents() - 0.01);
        }
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
