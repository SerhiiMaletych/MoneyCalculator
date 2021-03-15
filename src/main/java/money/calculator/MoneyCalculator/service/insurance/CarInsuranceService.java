package money.calculator.MoneyCalculator.service.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.model.Result;
import money.calculator.MoneyCalculator.model.insurance.CarModel;
import org.springframework.stereotype.Service;

@Service
public class CarInsuranceService {
    private double driverExperienceMultiplier;
    private double carEngineMultiplier;
    private double carModelMultiplier;
    private double yearOfProductionMultiplier;
    private double taxiMultiplier;


    public double doInsuranceResult(Car car) {
        checkCredentials(car);
        if (car.getResult() == Result.APPROVE) {
            return calculateInsurancePayment();

        } return 0;
    }


    public double calculateInsurancePayment() {

            double basePayment = 100;
            return basePayment * driverExperienceMultiplier * carModelMultiplier * carEngineMultiplier *
                    yearOfProductionMultiplier * taxiMultiplier;

    }

    public double checkForTaxi(Car car) {
        if (car.isTaxi()) {
            return taxiMultiplier = 1.5;
        } else return taxiMultiplier = 1;
    }


    public double calculateCarModelMultiplier(Car car) {
        if (car.getCarModel() == CarModel.AUDI || car.getCarModel() == CarModel.BMW ||
                car.getCarModel() == CarModel.FERRARI || car.getCarModel() == CarModel.PORSHE ||
                car.getCarModel() == CarModel.TESLA || car.getCarModel() == CarModel.MERCEDES) {
            return carModelMultiplier = 1.3;
        } else if (car.getCarModel() == CarModel.ZAZ_ZAPOROZHEC) {
            return carModelMultiplier = 2;

        } else if (car.getCarModel() == CarModel.NONE) {
            System.out.println("Please select some car model from the list!");
            return carModelMultiplier = 0;

        } else return carModelMultiplier = 1;
    }

    public double calculateDriverExperienceMultiplier(Car car) {
        if (car.getDriverExperience() < 1) {
            return driverExperienceMultiplier = 2;
        } else if (car.getDriverExperience() >= 1 && car.getDriverExperience() < 3) {
            return driverExperienceMultiplier = 1.7;
        } else if (car.getDriverExperience() >= 3 && car.getDriverExperience() < 5) {
            return driverExperienceMultiplier = 1.4;
        } else if (car.getDriverExperience() >= 5) {
            return driverExperienceMultiplier = 1;
        }
        return 0;
    }

    public double calculateCarEngineMultiplier(Car car) {
        if (car.getCarEngine() < 1) {
            return carEngineMultiplier = 1;
        } else if (car.getCarEngine() >= 1 && car.getCarEngine() < 1.5) {
            return carEngineMultiplier = 1.2;
        } else if (car.getCarEngine() >= 1.5 && car.getCarEngine() < 2) {
            return carEngineMultiplier = 1.4;
        } else if (car.getCarEngine() >= 2 && car.getCarEngine() < 2.5) {
            return carEngineMultiplier = 1.6;
        } else if (car.getCarEngine() >= 2.5 && car.getCarEngine() < 3) {
            return carEngineMultiplier = 1.8;
        } else if (car.getCarEngine() >= 3) {
            return carEngineMultiplier = 2;
        }
        return 0;
    }

    public double calculateYearOfProductionMultiplier(Car car) {
        if (car.getYearOfProduction() > 1970 && car.getYearOfProduction() <= 1980) {
            return yearOfProductionMultiplier = 2;
        } else if (car.getYearOfProduction() > 1980 && car.getYearOfProduction() <= 1990) {
            return yearOfProductionMultiplier = 1.8;
        } else if (car.getYearOfProduction() > 1990 && car.getYearOfProduction() <= 2000) {
            return yearOfProductionMultiplier = 1.6;
        } else if (car.getYearOfProduction() > 2000 && car.getYearOfProduction() <= 2010) {
            return yearOfProductionMultiplier = 1.4;
        } else if (car.getYearOfProduction() > 2010 && car.getYearOfProduction() <= 2020) {
            return yearOfProductionMultiplier = 1.2;
        } else if (car.getYearOfProduction() > 2020) {
            return yearOfProductionMultiplier = 1;
        }
        return 0;
    }

    public void checkCredentials(Car car) {
        if (car.getCarEngine() <= 0 || car.getCarModel() == null || car.getDriverExperience() < 0
                || car.getYearOfProduction() < 1970 || car.getAge() < 16 || car.getName().isEmpty()
                || car.getName().isBlank()) {
            car.setResult(Result.REJECT);
        }
    }

    public Car clear(Car car) {
        car.setName("");
        car.setAge(0);
        car.setCarModel(CarModel.NONE);
        car.setCarEngine(0);
        car.setYearOfProduction(1971);
        car.setDriverExperience(0);
        car.setTaxi(false);
        return car;
    }

}
