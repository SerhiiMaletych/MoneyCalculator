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
    public void testDifferentHouseInsurancePayments() {
        House house = new House("Vladimir", 111111, 80, 2005);
        House house1 = new House("Vladimir", 24000, 40, 1960);
        House house2 = new House("Vladimir", 480000, 330, 2016);
        House house3 = new House("", 111111, 80, 2005);

        assertEquals(houseInsuranceService.findInsurancePayment(house),2470.0);
        assertEquals(houseInsuranceService.findInsurancePayment(house1),2475.0000000000005);
        assertEquals(houseInsuranceService.findInsurancePayment(house2),7500.0);
        assertEquals(houseInsuranceService.findInsurancePayment(house3),0);




    }
    @Test
    public void testDifferentYearsOfConstructionMultipliers() {
        House house = new House("Serhii", 50000, 100, 1790);
        House house1 = new House("Serhii", 50000, 100, 2015);
        House house2 = new House("Serhii", 50000, 100, 2005);
        House house3 = new House("Serhii", 50000, 100, 1995);
        House house4 = new House("Serhii", 50000, 100, 1980);
        House house5 = new House("Serhii", 50000, 100, 1950);
        House house6 = new House("Serhii", 50000, 100, 1910);
        House house7 = new House("Serhii", 50000, 100, 1870);
        House house8 = new House("Serhii", 50000, 100, 1801);

        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house), 0);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house1), 1);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house2), 1.3);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house3), 1.5);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house4), 2);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house5), 3);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house6), 4);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house7), 7);
        assertEquals(houseInsuranceService.findYearOfConstructionMultiplier(house8), 10);



    }


    @Test
    public void testDifferentHousePriceMultipliers() {
        House house = new House("John", 15000, 2000, 2019);
        House house1 = new House("John", 35000, 2000, 2019);
        House house2 = new House("John", 55000, 2000, 2019);
        House house3 = new House("John", 120000, 2000, 2019);
        House house4 = new House("John", 333333, 2000, 2019);
        House house5 = new House("John", 999999, 2000, 2019);
        House house6 = new House("John", 4444444, 2000, 2019);
        House house7 = new House("John", 0, 2000, 2019);

        assertEquals(houseInsuranceService.findHousePriceMultiplier(house), 1);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house1), 1.1);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house2), 1.2);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house3), 2);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house4), 3);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house5), 5);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house6), 10);
        assertEquals(houseInsuranceService.findHousePriceMultiplier(house7), 0);



    }
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
