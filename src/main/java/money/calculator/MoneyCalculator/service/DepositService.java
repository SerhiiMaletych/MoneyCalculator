package money.calculator.MoneyCalculator.service;


import money.calculator.MoneyCalculator.entity.Deposit;
import org.springframework.stereotype.Service;

@Service
public class DepositService {


    public double calculateDeposit(Deposit deposit) {
        return deposit.getSum() + calculatePercents(deposit);

    }

    public double calculatePercents(Deposit deposit) {
        findPercents(deposit);
        if(deposit.getPeriod()==0) {
            return 0;
        }
        else return deposit.getSum() * deposit.getPercents() * deposit.getPeriod() / 12;

    }

    public double findPercents(Deposit deposit) {
        if(deposit.getPeriod()==0) return deposit.setPercents(0);
        else if (deposit.getPeriod()>0 && deposit.getPeriod()<= 3) return deposit.setPercents(0.05);
        else if (deposit.getPeriod() <= 6) return deposit.setPercents(0.07);
        else if (deposit.getPeriod() <= 9) return deposit.setPercents(0.085);
        else if (deposit.getPeriod() >= 10) return deposit.setPercents(0.09);

        return 0;
    }

    public Deposit clear(Deposit deposit) {
        deposit.setSum(0);
        deposit.setPeriod(0);
        return deposit;
    }
}
