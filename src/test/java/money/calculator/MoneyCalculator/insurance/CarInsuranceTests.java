package money.calculator.MoneyCalculator.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.service.insurance.CarInsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarInsuranceTests {

    @Autowired
    CarInsuranceService carInsuranceService;




















    @Test
    public void testForRightCarEngineInput() {
        Car car = new Car();
        car.setCarEngine(0);
        carInsuranceService.checkCredentials(car);
        assertEquals(car.getResult(), Result.REJECT);
    }

    @Test
    public void testForNotSubZeroDriverExperience() {
        Car car = new Car();
        car.setYearOfProduction(-1);
        carInsuranceService.checkCredentials(car);
        assertEquals(car.getResult(), Result.REJECT);

    }

    @Test
    public void testForRightYearOfProduction() {
        Car car = new Car();
        car.setYearOfProduction(1990);
        carInsuranceService.checkCredentials(car);
        assertEquals(car.getResult(), Result.REJECT);

    }

    @Test
    public void testForAge() {
        Car car = new Car();
        car.setAge(15);
        carInsuranceService.checkCredentials(car);
        assertEquals(car.getResult(), Result.REJECT);

    }

    @Test
    public void testForNotEmptyName() {
        Car car = new Car();
        Car car1 = new Car();
        car.setName("");
        car1.setName(null);
        carInsuranceService.checkCredentials(car);
        carInsuranceService.checkCredentials(car1);
        assertEquals(car.getResult(), Result.REJECT);
        assertEquals(car1.getResult(), Result.REJECT);


    }
}
