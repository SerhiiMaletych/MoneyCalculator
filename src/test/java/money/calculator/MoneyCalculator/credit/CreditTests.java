package money.calculator.MoneyCalculator.credit;

import money.calculator.MoneyCalculator.entity.Credit;
import money.calculator.MoneyCalculator.model.Employed;
import money.calculator.MoneyCalculator.model.Married;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.Sex;
import money.calculator.MoneyCalculator.model.credit.Conviction;
import money.calculator.MoneyCalculator.service.CreditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditTests {

    @Autowired
    CreditService creditService;

    public void findCreditResult(Credit credit) {
        var division = credit.getSum() / credit.getSalary();

        if (division < 10) {
            credit.setResult(Result.APPROVE);
        }
        else credit.setResult(Result.REJECT);
    }

    @Test
    public void checkCreditResultDependingOnSalary() {
        Credit credit = new Credit();
        Credit credit1 = new Credit();
        credit.setSum(100000);
        credit.setSalary(11111);
        credit1.setSum(50000);
        credit1.setSalary(3000);
        creditService.findCreditResult(credit);
        creditService.findCreditResult(credit1);
        assertEquals(credit.getResult(),Result.APPROVE);
        assertEquals(credit1.getResult(),Result.REJECT);

    }


    @Test
    public void testRightPercentsCalculation() {
        Credit credit = new Credit();
        Credit credit1 = new Credit();
        Credit credit2 = new Credit();
        credit.setSum(10000);
        credit.setSalary(4000);
        credit.setPeriod(6);
        credit1.setSum(100000);
        credit1.setSalary(10000);
        credit1.setPeriod(12);
        credit2.setSum(35000);
        credit2.setSalary(3500);
        credit2.setPeriod(4);
        creditService.findPercentsForCredit(credit);
        creditService.findPercentsForCredit(credit1);
        creditService.findPercentsForCredit(credit2);
        assertEquals(creditService.calculateAmountOfPercentPayment(credit), 450);
        assertEquals(creditService.calculateAmountOfPercentPayment(credit1), 13000);
        assertEquals(creditService.calculateAmountOfPercentPayment(credit2), 1516.6666666666667);

    }

    @Test
    public void testCLearButton() {
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
        credit.setPercents(0.11);
        credit1.setConviction(Conviction.YES);
        credit1.setPercents(0.1);
        creditService.checkConviction(credit);
        creditService.checkConviction(credit1);
        assertEquals(0.12, credit.getPercents());
        assertEquals(0.1, credit1.getPercents());
    }

    @Test
    public void checkAmountOfSalaryToGetCredit() {
        Credit credit = new Credit();
        Credit credit1 = new Credit();
        credit.setSalary(5000);
        credit1.setSalary(1000);
        creditService.checkSalary(credit);
        creditService.checkSalary(credit1);
        assertEquals(Result.APPROVE, credit.getResult());
        assertEquals(Result.REJECT, credit1.getResult());

    }

}
