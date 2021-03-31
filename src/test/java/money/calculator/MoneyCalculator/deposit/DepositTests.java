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
        Deposit deposit = new Deposit();
        deposit.setSum(10);
        deposit.setPeriod(10);
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
        Deposit deposit = new Deposit(1000, 2, 0.05);
        Deposit deposit1 = new Deposit(5000, 5, 0.07);
        Deposit deposit2 = new Deposit(7000, 7, 0.0085);

        assertEquals(8.333333333333334, depositService.calculatePercents(deposit));
        assertEquals(145.83333333333334, depositService.calculatePercents(deposit1));
        assertEquals(347.0833333333333, depositService.calculatePercents(deposit2));


    }

    @Test
    public void calculateDeposit() {
        Deposit deposit = new Deposit();
        deposit.setSum(1000);
        deposit.setPercents(0.05);
        deposit.setPeriod(2);
        assertEquals(1008.0, depositService.calculateDeposit(deposit));
    }

    @Test
    public void testClearButton() {
        Deposit deposit = new Deposit(10000, 10);
        Deposit deposit1 = new Deposit(5000, 7);
        depositService.clear(deposit);
        depositService.clear(deposit1);
        assertEquals(deposit.getSum(), 0);
        assertEquals(deposit1.getSum(), 0);
        assertEquals(deposit.getPeriod(), 0);
        assertEquals(deposit1.getPeriod(), 0);

    }


}
