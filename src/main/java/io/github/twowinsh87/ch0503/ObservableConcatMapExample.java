package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample {

    public static void main(String[] args) {

        /**
         * 순서를 보장해주는 concatMap 예제
         * 순차적으로 실행되기때문에 flatMap보다 느리다.
         */
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .concatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " * " + row + " = " + num * row)
                ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> {},
                () -> {
                    TimeUtil.end();
                    TimeUtil.takeTime();
                }
        );

        TimeUtil.sleep(5000L);


        /**
         * concatMap과 달리 순서를 보장해주지 않는 flatMap의 예제
         * 실행 속도가 concatMap 보다 빠르다.
        */
        /*
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .flatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " * " + row + " = " + num * row)
                )
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {},
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        });

        TimeUtil.sleep(3000L);
         */

    }

}
