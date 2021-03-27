package money.calculator.MoneyCalculator.service.insurance;

import ch.qos.logback.core.net.HardenedObjectInputStream;
import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.entity.insurance.House;
import money.calculator.MoneyCalculator.entity.insurance.Life;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.CarModel;
import money.calculator.MoneyCalculator.model.insurance.Taxi;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HouseInsuranceService {
    private double housePriceMultiplier;
    private double houseAreaMultiplier;
    private double yearOfConstructionMultiplier;
    Date date=  new Date();


    private double findInsurancePayment(House house){
        int basePayment = 500;
        checkCredentials(house);
        findHouseAreaMultiplier(house);
        findHousePriceMultiplier(house);
        findYearOfConstructionMultiplier(house);
        if(house.getResult()==Result.APPROVE){
            return basePayment*houseAreaMultiplier*housePriceMultiplier*yearOfConstructionMultiplier;

        }
        else return 0;
    }

    private double findYearOfConstructionMultiplier(House house) {
        int currentYear = date.getYear();
        if(house.getYearOfConstruction()>currentYear || house.getYearOfConstruction()<1800){
            return yearOfConstructionMultiplier=0;
        }
        else if(house.getYearOfConstruction()>2010) {
            return yearOfConstructionMultiplier = 1;
        }
        else if(house.getYearOfConstruction()>2000) {
            return yearOfConstructionMultiplier=1.3;
        }
        else if(house.getYearOfConstruction()>1990) {
            return yearOfConstructionMultiplier=1.5;
        }
        else if(house.getYearOfConstruction()>1970){
            return yearOfConstructionMultiplier=2;
        }
        else if(house.getYearOfConstruction()>1940) {
            return yearOfConstructionMultiplier=3;
        }
        else if(house.getYearOfConstruction()>1900) {
            return yearOfConstructionMultiplier =4;
        }
        else if (house.getYearOfConstruction()>1850) {
            return yearOfConstructionMultiplier=7;
        }
        else if(house.getYearOfConstruction()>1800) {
            return yearOfConstructionMultiplier=10;
        }
        else return 0;


    }

    private double findHouseAreaMultiplier(House house) {
        if(house.getHouseArea()<30){
            return houseAreaMultiplier=1;
        }
        else if(house.getHouseArea()<60){
            return houseAreaMultiplier=1.5;
        }
        else if(house.getHouseArea()<100) {
            return houseAreaMultiplier=1.9;
        }
        else if(house.getHouseArea()<150){
            return houseAreaMultiplier=2.5;
        }
        else if (house.getHouseArea()<250){
            return houseAreaMultiplier=3;
        }
        else if(house.getHouseArea()<400){
            return houseAreaMultiplier=5;
        }
        else if(house.getHouseArea()>400){
            return houseAreaMultiplier=10;
        }
        else return 0;
    }


    private double findHousePriceMultiplier(House house) {
        if(house.getHousePrice()<20000) {
            return houseAreaMultiplier=1;
        }
        else if(house.getHousePrice()<40000) {
            return housePriceMultiplier=1.1;
        }
        else if(house.getHousePrice()<60000) {
            return housePriceMultiplier=1.2;
        }
        else if(house.getHousePrice()<150000) {
            return housePriceMultiplier=2;
        }
        else if(house.getHousePrice()<500000) {
            return housePriceMultiplier=3;
        }
        else if(house.getHousePrice()<1000000) {
            return housePriceMultiplier=5;
        }
        else if(house.getHousePrice()>1000001){
            return housePriceMultiplier =10;
        }
        else return 0;
    }

    public void checkCredentials(House house) {
        int currentYear = date.getYear();
        if (house.getName().isEmpty() || house.getName().isBlank() || house.getYearOfConstruction() < 1800 ||
                house.getYearOfConstruction() > currentYear || house.getHouseArea()<=0 || house.getHouseArea()>2000 ||
                house.getHousePrice()<=0 || house.getHousePrice()>999999999) {
            house.setResult(Result.REJECT);
        } else house.setResult(Result.APPROVE);
    }
    public House clear(House house) {
        house.setName("");
        house.setYearOfConstruction(0);
        house.setHouseArea(0);
        house.setHousePrice(0);
        return house;
    }
}
