package money.calculator.MoneyCalculator.deposit;

import money.calculator.MoneyCalculator.entity.Deposit;
import money.calculator.MoneyCalculator.service.DepositService;
import org.junit.Test;
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
        assertEquals(deposit.getSum(), 0);
        assertEquals(deposit.getPeriod(), 0);

    }

    @Test
    public void testFindingPercents() {
        Deposit deposit = new Deposit();
        deposit.setPeriod(2);
        depositService.findPercents(deposit);
        assertEquals(deposit.getPercents(),0.05);
    }
}
