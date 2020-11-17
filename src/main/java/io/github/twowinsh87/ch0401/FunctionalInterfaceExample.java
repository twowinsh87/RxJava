package io.github.twowinsh87.ch0401;

import io.github.twowinsh87.common.*;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(CarMaker.HYUNDAE, CarType.SUV, "팰리세이드", 28000000, true),
                new Car(CarMaker.SAMSUNG, CarType.SEDAN, "SM5", 35000000, true),
                new Car(CarMaker.CHEVROLET, CarType.SUV, "트래버스", 50000000, true),
                new Car(CarMaker.KIA, CarType.SEDAN, "K5", 20000000, false),
                new Car(CarMaker.SSANGYOUNG, CarType.SUV, "티볼리", 23000000, true)
        );

        //Legacy
//        List<Car> carsFilteredByPrice = CarFilter.filterCarByCustomPredicate(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getCarPrice() > 30000000;
//            }
//        });

        //Lambda
        List<Car> carsFilteredByPrice = CarFilter.filterCarByCustomPredicate(cars, (Car car) -> car.getCarPrice() > 30000000);

        for(Car car : carsFilteredByPrice)
            System.out.println("차 이름: " + car.getCarName() + ", 가격: " + car.getCarPrice());

        //Legacy
//        List<Car> carsFilteredByCarType = CarFilter.filterCarByCustomPredicate(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getCarType().equals(CarType.SUV);
//            }
//        });

        //Lambda
        List<Car> carsFilteredByCarType =  CarFilter.filterCarByCustomPredicate(cars, (Car car) -> car.getCarType().equals(CarType.SUV));

        for(Car car : carsFilteredByCarType)
            System.out.println("차 이름: " + car.getCarName() + ", 차종: " + car.getCarType());
    }
}
