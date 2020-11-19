package io.github.twowinsh87.ch0502;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTakeExample {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d")
                .take(2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));


        System.out.println("----------------------------------------------");

        Observable.interval(1000L, TimeUnit.MILLISECONDS) //Interval로 1초에 한번씩 데이터를 통지. main Thread 아님
                .take(4000L, TimeUnit.MILLISECONDS) //4초 범위 내에 데이터만 '통지'
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(5000L);
    }
}
