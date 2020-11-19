package io.github.twowinsh87.ch0502quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Quiz02 {
    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeWhile(count -> count != 10) // 10전까지
                .subscribe(count -> Logger.log(LogType.ON_NEXT, count));

        TimeUtil.sleep(10000L);
    }
}
