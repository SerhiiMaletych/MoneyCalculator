package money.calculator.MoneyCalculator.deposit;

import money.calculator.MoneyCalculator.entity.Deposit;
import money.calculator.MoneyCalculator.service.DepositService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepositTests {

    @Autowired
    DepositService depositService;


    @Test
    public void testClear() {
        Deposit deposit = new Deposit(10, 10);
        depositService.clear(deposit);
        assertEquals(0, deposit.getSum());
        assertEquals(0, deposit.getPeriod());

    }

    @Test
    public void findPercents() {
        Deposit deposit = new Deposit();
        Deposit deposit1 = new Deposit();
        Deposit deposit2 = new Deposit();
        Deposit deposit3 = new Deposit();

        deposit.setPeriod(2);
        deposit1.setPeriod(5);
        deposit2.setPeriod(7);
        deposit3.setPeriod(10);

        depositService.findPercents(deposit);
        depositService.findPercents(deposit1);
        depositService.findPercents(deposit2);
        depositService.findPercents(deposit3);

        assertEquals(0.05, deposit.getPercents());
        assertEquals(0.07, deposit1.getPercents());
        assertEquals(0.085, deposit2.getPercents());
        assertEquals(0.09, deposit3.getPercents());

    }

    @Test
    public void calculatePercents() {
        Deposit deposit = new Deposit();
        deposit.setSum(1000);
        deposit.setPercents(0.05);
        deposit.setPeriod(2);
        assertEquals(8.333333333333334, depositService.calculatePercents(deposit));

    }

    @Test
    public void calculateDeposit() {
        Deposit deposit = new Deposit();
        deposit.setSum(1000);
        deposit.setPercents(0.05);
        deposit.setPeriod(2);
        assertEquals(1008.3333333333334, depositService.calculateDeposit(deposit));
    }


}
