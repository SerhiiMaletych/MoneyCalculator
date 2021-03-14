package money.calculator.MoneyCalculator.service.insurance;

import money.calculator.MoneyCalculator.entity.insurance.Car;
import money.calculator.MoneyCalculator.model.Result;
import org.springframework.stereotype.Service;

@Service
public class CarInsuranceService {
        private double driverExperienceMultiplier;
        private double carEngineMultiplier;
        private double carModelMultiplier;
        private double yearOfProductionMultiplier;
        private final double basePayment =100;


        public double calculateYearOfProductionMultiplier (Car car) throws Exception {
            if(car.getYearOfProduction()>1970 && car.getYearOfProduction()<=1980) {
                return yearOfProductionMultiplier=2;
            }
            else if( car.getYearOfProduction()>1980 && car.getYearOfProduction()<=1990) {
                return  yearOfProductionMultiplier = 1.8;
            }
            else if (car.getYearOfProduction()>1990 && car.getYearOfProduction()<=2000) {
                return yearOfProductionMultiplier = 1.6;
            }
            else if(car.getYearOfProduction()>2000 && car.getYearOfProduction()<=2010) {
                return yearOfProductionMultiplier = 1.4;
            }
            else if(car.getYearOfProduction()>2010 && car.getYearOfProduction()<=2020){
                return yearOfProductionMultiplier = 1.2;
            }
            else if (car.getYearOfProduction()>2020) {
                return yearOfProductionMultiplier = 1;
            }
            else throw new Exception("Wrong year!");
        }
        public void checkCredentials(Car car) {
            if(car.getCarEngine()<=0 || car.getCarModel()==null || car.getDriverExperience()<0
            || car.getYearOfProduction()<1970 || car.getAge()<16 || car.getName().isEmpty()
            || car.getName().isBlank()) {
                car.setResult(Result.REJECT);
            }
        }
}
