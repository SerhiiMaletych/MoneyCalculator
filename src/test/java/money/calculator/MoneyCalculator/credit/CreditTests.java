package money.calculator.MoneyCalculator.credit;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.*;
import money.calculator.MoneyCalculator.model.credit.Conviction;
import money.calculator.MoneyCalculator.model.credit.CreditResult;
import money.calculator.MoneyCalculator.service.CreditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditTests {

    @Autowired
    CreditService creditService;

    @Test
    public void testCLearCredit() {
        Credit credit = new Credit();
        credit.setName("Name");
        credit.setSum(100);
        credit.setAge(20);
        credit.setConviction(Conviction.YES);
        credit.setEmployed(Employed.YES);
        credit.setSex(Sex.MALE);
        credit.setSalary(4000);
        credit.setMarried(Married.YES);
        creditService.clear(credit);
        assertEquals("0", credit.getName());
        assertEquals(0, credit.getSum());
        assertEquals(0, credit.getAge());
        assertEquals(Conviction.NO, credit.getConviction());
        assertEquals(Employed.NO, credit.getEmployed());
        assertEquals(Sex.NONE, credit.getSex());
        assertEquals(0, credit.getSalary());
        assertEquals(Married.NO, credit.getMarried());



    }
    @Test
    public void checkBonusPercentsForNoConviction() {
        Credit credit = new Credit();
        Credit credit1 = new Credit();
        credit.setConviction(Conviction.NO);
        credit.setPercents(10);
        credit1.setConviction(Conviction.YES);
        credit1.setPercents(10);
        creditService.checkConviction(credit);
        creditService.checkConviction(credit1);
        assertEquals(11, credit.getPercents());
        assertEquals(10, credit1.getPercents());
    }

    @Test
    public void checkAmountofSalaryToGetCredit() {
        Credit credit = new Credit();
        Credit credit1 = new Credit();
        credit.setSalary(5000);
        credit1.setSalary(1000);
        creditService.checkSalary(credit);
        creditService.checkSalary(credit1);
        assertEquals(CreditResult.APPROVE, credit.getCreditResult());
        assertEquals(CreditResult.REJECT, credit1.getCreditResult());

    }

}
