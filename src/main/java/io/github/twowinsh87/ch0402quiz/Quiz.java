package io.github.twowinsh87.ch0402quiz;

import io.github.twowinsh87.common.Car;
import io.github.twowinsh87.common.CarType;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Quiz {
    public static void main(String[] args) {
        //메서드 레퍼런스로 축약
        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> p2 = String::isEmpty;
        System.out.println(p2.test("not empty"));


        Function<Integer, String> f1 = i -> String.valueOf(i);
        Function<Integer, String> f2 = String::valueOf;
        System.out.println(f2.apply(3));


        BiPredicate<List<Integer>, Integer> bp1 = (list, num) -> list.contains(num);
        BiPredicate<List<Integer>, Integer> bp2 = List::contains; //ClassName::Method
        System.out.println(bp2.test(Arrays.asList(1, 2, 3, 4, 5), 3));


        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;
        c2.accept("찍힌다");


        //String, CatType 인자로 받고, Car class type 으로 리턴
        BiFunction<String, CarType, Car> bf1 = (s1, s2) -> new Car(s1, s2);
        BiFunction<String, CarType, Car> bf2 = Car::new; // 어떤 Class :: 객체 생성 new
        Car car = bf2.apply("QM6", CarType.SUV);
        System.out.println("자동차 생산 완료: carName: " + car.getCarName() + "  carType: " + car.getCarType());

    }
}
