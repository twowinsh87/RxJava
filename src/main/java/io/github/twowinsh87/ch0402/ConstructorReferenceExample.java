package io.github.twowinsh87.ch0402;

import io.github.twowinsh87.common.Car;

import java.util.function.Function;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Function<String, Car> f1 = s -> new Car(s); //전달 받는 값이 Function<String, Car> String 인지 알 수 있기 때문에 가능
        Car car1 = f1.apply("콜로라도");
        System.out.println(car1.getCarName());

        Function<String, Car> f2 = Car::new;
        Car car2 = f2.apply("카니발");
        System.out.println(car2.getCarName());
    }
}
