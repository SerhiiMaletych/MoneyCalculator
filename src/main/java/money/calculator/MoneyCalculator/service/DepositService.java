package money.calculator.MoneyCalculator.service;

import money.calculator.MoneyCalculator.entity.Deposit;
import org.springframework.stereotype.Service;

@Service
public class DepositService {


    public double calculateDeposit(Deposit deposit) {
        return deposit.getSum()+calculatePercents(deposit);

    }
    public double calculatePercents(Deposit deposit) {
        findPercents(deposit);
        return deposit.getSum()*deposit.getPercents();

    }

    public void findPercents(Deposit deposit) {
        if(deposit.getPeriod()<=3)  deposit.setPercents(0.05);
        else if(deposit.getPeriod()<=6)   deposit.setPercents(0.07);
        else if(deposit.getPeriod()<=9)  deposit.setPercents(0.085);
        else if(deposit.getPeriod()>10)  deposit.setPercents(0.09);

    }
}
