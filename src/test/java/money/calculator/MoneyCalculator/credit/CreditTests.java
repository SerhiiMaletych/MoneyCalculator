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


    @Test
    public void testRightMonthlyPayments() {
        Credit credit = new Credit("Sofi", Sex.FEMALE, Employed.YES, Conviction.NO, Married.YES, 40,
                20000, 10000, 10);
        Credit credit1 = new Credit("Jack", Sex.MALE, Employed.YES, Conviction.YES, Married.NO, 36,
                15000, 7000, 8);
        Credit credit2 = new Credit("Julia", Sex.FEMALE, Employed.NO, Conviction.NO, Married.YES, 60,
                10000, 1, 6);
        assertEquals(creditService.findMonthPayment(credit), 2233.0);
        assertEquals(creditService.findMonthPayment(credit1), 2012.0);
        assertEquals(creditService.findMonthPayment(credit2), 0);

    }

    @Test
    public void testFindRightCreditSum() {
        Credit credit = new Credit("Sofi", Sex.FEMALE, Employed.YES, Conviction.NO, Married.YES, 40,
                20000, 10000, 10);
        Credit credit1 = new Credit("Jack", Sex.MALE, Employed.YES, Conviction.YES, Married.NO, 36,
                15000, 7000, 8);
        Credit credit2 = new Credit("Julia", Sex.FEMALE, Employed.NO, Conviction.NO, Married.YES, 60,
                10000, 1, 6);
        assertEquals(creditService.findCreditSum(credit), 22333.0);
        assertEquals(creditService.findCreditSum(credit1), 16100.0);
        assertEquals(creditService.findCreditSum(credit2), 0);


    }

    @Test
    public void checkCreditResultDependingOnSalary() {
        Credit credit = new Credit(100000, 11111);
        Credit credit1 = new Credit(50000, 3000);
        creditService.findCreditResult(credit);
        creditService.findCreditResult(credit1);
        assertEquals(credit.getResult(), Result.APPROVE);
        assertEquals(credit1.getResult(), Result.REJECT);

    }


    @Test
    public void testRightPercentsCalculation() {
        Credit credit = new Credit(10000, 4000, 6);
        Credit credit1 = new Credit(100000, 10000, 12);
        Credit credit2 = new Credit(35000, 3500, 4);
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

    @Test
    public void testCredentials() {
        Credit credit = new Credit("Oksana", Employed.YES, 30, 10000);
        Credit credit1 = new Credit("Petro", Employed.NO, 25, 0);
        Credit credit2 = new Credit("Fedor", Employed.YES, 14, 2000);

        creditService.checkCredentials(credit);
        creditService.checkCredentials(credit1);
        creditService.checkCredentials(credit2);

        assertEquals(Result.APPROVE, credit.getResult());
        assertEquals(Result.REJECT, credit1.getResult());
        assertEquals(Result.REJECT, credit2.getResult());


    }

}
