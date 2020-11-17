package io.github.twowinsh87.ch0402;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class ObjectInstanceMethodExample {
    public static void main(String[] args) {
        final CarInventory carInventory = new CarInventory(10);

        Function<Integer, Integer> f1 = count -> carInventory.getExpectedTotalCount(count);
        int totalCount1 = f1.apply(10);
        System.out.println(totalCount1);

        Function<Integer, Integer> f2 = carInventory::getExpectedTotalCount;
        int totalCount2 = f2.apply(20);
        System.out.println(totalCount2);

        // T -> T 즉 파라미터랑 리턴값이 같을 떄 사용할 수 있음 = UnaryOperator
        UnaryOperator<Integer> f3 = carInventory::getExpectedTotalCount;
        int totalCount3 = f3.apply(30);
        System.out.println(totalCount3);

        // Integer -> Integer
        IntUnaryOperator f4 = carInventory::getExpectedTotalCount;
        int totalCount4 = f4.applyAsInt(40);
        System.out.println(totalCount4);
    }
}
