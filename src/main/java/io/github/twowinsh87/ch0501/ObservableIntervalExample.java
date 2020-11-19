package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num + "count")
                .subscribe(data -> Logger.log(LogType.DO_ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
