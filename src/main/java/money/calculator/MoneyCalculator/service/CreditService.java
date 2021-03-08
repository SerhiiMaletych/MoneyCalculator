package money.calculator.MoneyCalculator.service;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.*;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    public void findCreditSum(Credit credit) {
        findCreditResult(credit);
        if (credit.getCreditResult() == CreditResult.APPROVE) {
            checkConviction(credit);
        }
    }

    public boolean findCreditResult(Credit credit) {
        var division = credit.getSum() / credit.getSalary();
        checkCredentials(credit);
        checkSalary(credit);
        if (division < 10) {
            return credit.getCreditResult() == CreditResult.APPROVE;
        }
        return false;
    }


    public void checkSalary(Credit credit) {
        if (credit.getSalary() < 3000) {
            credit.setCreditResult(CreditResult.REJECT);
        }
    }

    public void checkCredentials(Credit credit) {
        if (credit.getName().isEmpty() || credit.getAge() < 18 || credit.getAge() > 90 ||
                credit.getSalary() < 100 || credit.getEmployed() == Employed.NO) {
            credit.setCreditResult(CreditResult.REJECT);
        }
    }


    public void checkConviction(Credit credit) {
        if (credit.getConviction() == Conviction.NO) {
            credit.setPercents(credit.getPercents() - 1);
        }
    }


    public double calculatePercents(Credit credit) {
        findPercents(credit);
        return credit.getSum() * credit.getPercents() * credit.getPeriod() / 12;

    }

    public void findPercents(Credit credit) {

        if (credit.getSum() / credit.getSalary() < 6 && credit.getPeriod() <= 9) {
            credit.setPercents(12);
        } else if (credit.getSum() / credit.getSalary() < 5 && credit.getPeriod() <= 8) {
            credit.setPercents(11);
        } else if (credit.getSum() / credit.getSalary() < 4 && credit.getPeriod() <= 7) {
            credit.setPercents(10);
        } else if (credit.getSum() / credit.getSalary() < 3 && credit.getPeriod() <= 6) {
            credit.setPercents(9);
        } else credit.setPercents(13);
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
