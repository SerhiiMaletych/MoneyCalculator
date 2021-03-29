package money.calculator.MoneyCalculator.insurance;


import money.calculator.MoneyCalculator.entity.insurance.House;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.service.insurance.HouseInsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HouseInsuranceTests {

    @Autowired
    HouseInsuranceService houseInsuranceService;



    @Test
    public void testDifferentHouseAreaMultipliers() {
        House house = new House("Bryan", 200000, 20, 2000);
        House house1 = new House("Bryan", 200000, 50, 2000);
        House house2 = new House("Bryan", 200000, 90, 2000);
        House house3 = new House("Bryan", 200000, 110, 2000);
        House house4 = new House("Bryan", 200000, 230, 2000);
        House house5 = new House("Bryan", 200000, 399, 2000);
        House house6 = new House("Bryan", 200000, 525, 2000);

        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house), 1);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house1), 1.5);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house2), 1.9);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house3), 2.5);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house4), 3);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house5), 5);
        assertEquals(houseInsuranceService.findHouseAreaMultiplier(house6), 10);


    }
    @Test
    public void testCredentialsToBeOk() {
        House house = new House("Sergey", 100000, 100, 1990);
        House house1 = new House("", 100000, 100, 1990);
        House house2 = new House("Sergey", 100000, 100000, 1990);
        House house3 = new House("Sergey", 100000, 100, 1790);

        houseInsuranceService.checkCredentials(house);
        houseInsuranceService.checkCredentials(house1);
        houseInsuranceService.checkCredentials(house2);
        houseInsuranceService.checkCredentials(house3);

        assertEquals(house.getResult(), Result.APPROVE);
        assertEquals(house1.getResult(), Result.REJECT);
        assertEquals(house2.getResult(), Result.REJECT);
        assertEquals(house3.getResult(), Result.REJECT);


    }

    @Test
    public void testClearButtonInHouseInsurance() {
        House house = new House("Helen", 200000, 100, 2000);
        houseInsuranceService.clear(house);
        assertEquals(house.getName(), "");
        assertEquals(house.getHousePrice(),0);
        assertEquals(house.getHouseArea(),0);
        assertEquals(house.getYearOfConstruction(),0);
    }
}
