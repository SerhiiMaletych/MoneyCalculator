package money.calculator.MoneyCalculator.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.CarModel;
import money.calculator.MoneyCalculator.model.insurance.Taxi;
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
    public void testCarInsuranceSum() {
        Car car = new Car(CarModel.AUDI, 2, 2015, 2, Taxi.YES);
        Car car1 = new Car(CarModel.DAEWOO, 3, 2002, 5, Taxi.NO);
        Car car2 = new Car(CarModel.ZAZ_ZAPOROZHEC, 1.5, 1980, 20, Taxi.NO);

        assertEquals(carInsuranceService.calculateInsurancePayment(car), 524.16);
        assertEquals(carInsuranceService.calculateInsurancePayment(car1), 280.0);
        assertEquals(carInsuranceService.calculateInsurancePayment(car2), 560.0);

    }

    @Test
    public void testTaxiMultiplier() {
        Car car = new Car();
        Car car1 = new Car();
        car.setIsTaxi(Taxi.YES);
        car1.setIsTaxi(Taxi.NO);
        assertEquals(carInsuranceService.checkForTaxi(car), 1.5);
        assertEquals(carInsuranceService.checkForTaxi(car1), 1);

    }


    @Test
    public void testForTaxi() {
        Car car = new Car();
        Car car1 = new Car();
        car.setIsTaxi(Taxi.YES);
        car1.setIsTaxi(Taxi.NO);
        assertEquals(car.getIsTaxi(), Taxi.YES);
        assertEquals(car1.getIsTaxi(), Taxi.NO);

    }

    @Test
    public void testDriverExpMultiplier() {
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        car.setDriverExperience(0);
        car1.setDriverExperience(2);
        car2.setDriverExperience(4);
        car3.setDriverExperience(6);
        assertEquals(carInsuranceService.calculateDriverExperienceMultiplier(car), 1.7);
        assertEquals(carInsuranceService.calculateDriverExperienceMultiplier(car1), 1.4);
        assertEquals(carInsuranceService.calculateDriverExperienceMultiplier(car2), 1.2);
        assertEquals(carInsuranceService.calculateDriverExperienceMultiplier(car3), 1);


    }

    @Test
    public void testCarEngineMultiplier() {
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        car.setCarEngine(1.5);
        car1.setCarEngine(2.5);
        car2.setCarEngine(3.5);
        assertEquals(carInsuranceService.calculateCarEngineMultiplier(car), 1.4);
        assertEquals(carInsuranceService.calculateCarEngineMultiplier(car1), 1.8);
        assertEquals(carInsuranceService.calculateCarEngineMultiplier(car2), 2);

    }

    @Test
    public void testYearOfProductionMultiplier() {
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        car.setYearOfProduction(2005);
        car1.setYearOfProduction(2015);
        car2.setYearOfProduction(1975);
        assertEquals(carInsuranceService.calculateYearOfProductionMultiplier(car), 1.4);
        assertEquals(carInsuranceService.calculateYearOfProductionMultiplier(car1), 1.2);
        assertEquals(carInsuranceService.calculateYearOfProductionMultiplier(car2), 2);

    }

    @Test
    public void testClearButton() {
        Car car = new Car();
        car.setName("Vasya");
        car.setAge(20);
        car.setCarEngine(2);
        car.setYearOfProduction(2000);
        car.setIsTaxi(Taxi.YES);
        car.setCarModel(CarModel.AUDI);
        carInsuranceService.clear(car);
        assertEquals(car.getName(), "");
        assertEquals(car.getAge(), 0);
        assertEquals(car.getCarEngine(), 0);
        assertEquals(car.getYearOfProduction(), 1971);
        assertEquals(car.getIsTaxi(), Taxi.NO);
        assertEquals(car.getCarModel(), CarModel.NONE);
    }

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

    @Test
    public void testAllCredentials() {
        Car car = new Car("Petya", 30, CarModel.AUDI, 3,
                2000, 5, Taxi.NO);
        carInsuranceService.checkCredentials(car);
        assertEquals(car.getResult(), Result.APPROVE);


    }
}
