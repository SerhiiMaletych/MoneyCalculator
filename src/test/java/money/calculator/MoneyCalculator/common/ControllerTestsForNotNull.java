package money.calculator.MoneyCalculator.common;

import money.calculator.MoneyCalculator.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerTestsForNotNull {
    @Autowired
    CarInsuranceController carInsuranceController;

    @Autowired
    CreditController creditController;

    @Autowired
    DepositController depositController;

    @Autowired
    HouseInsuranceController houseInsuranceController;

    @Autowired
    LifeInsuranceController lifeInsuranceController;

    @Autowired
    MainController mainController;

    @Test
    public void testCarInsuranceControllerForNotNull() {
        assertThat(carInsuranceController).isNotNull();
    }

    @Test
    public void testCreditControllerForNotNull() {
        assertThat(creditController).isNotNull();
    }

    @Test
    public void testDepositControllerForNotNull() {
        assertThat(depositController).isNotNull();
    }

    @Test
    public void testHouseInsuranceControllerForNotNull() {
        assertThat(houseInsuranceController).isNotNull();
    }

    @Test
    public void testLifeInsuranceControllerForNotNull() {
        assertThat(lifeInsuranceController).isNotNull();
    }

    @Test
    public void testMainControllerForNotNull() {
        assertThat(mainController).isNotNull();
    }

}
