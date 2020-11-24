package io.github.twowinsh87.ch0505;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatExample01 {

    public static void main(String[] args) {
        Observable<Long> observable1 =
                Observable.interval(500L, TimeUnit.MILLISECONDS)
                        .take(4);

        Observable<Long> observable2 =
                Observable.interval(300L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(num -> num + 1000);

        Observable.concat(observable2, observable1)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));


        TimeUtil.sleep(3500L);
    }
}
