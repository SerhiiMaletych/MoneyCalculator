package money.calculator.MoneyCalculator.service;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.Conviction;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Sex;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    public Credit clear(Credit credit) {
       credit.setName("0");
       credit.setSum(0);
       credit.setAge(0);
       credit.setConviction(Conviction.NO);
       credit.setEmployed(Employed.NO);
       credit.setSex(Sex.NONE);
       credit.setSalary(0);

        return credit;
    }

}
