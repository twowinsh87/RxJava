package io.github.twowinsh87.ch0503quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class Quiz02 {

    /** range, filter, flatMap 을 이용하여 2부터 9까지 구구단 중에서 짝수단만 출력*/
    public static void main(String[] args) {

//        Observable.range(2, 8)
//                .filter(num -> num % 2 == 0)
//                .flatMap(
//                        num -> Observable.range(1, 9)
//                                .map(row -> num + " * " + row + " = " + num * row)
//                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        /** range, filter, flatMap 을 이용하여 2부터 9까지 구구단 중에서 짝수 결과만 출력*/
        Observable.range(2,8)
                .flatMap(
                        integer -> Observable.range(1,9)
                                            .map(row -> row * integer)
                                            .filter(f -> f % 2 == 0)
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
