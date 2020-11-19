package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample01 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("# start : " + TimeUtil.getCurrentTimeFormatted());
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .switchMap(
                        num -> Observable.interval(300L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " * " + row + " = " + num * row)
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        Thread.sleep(5000);
    }
}
