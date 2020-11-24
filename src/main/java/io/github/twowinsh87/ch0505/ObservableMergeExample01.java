package io.github.twowinsh87.ch0505;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableMergeExample01 {

    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(200L, TimeUnit.MILLISECONDS)
                .take(5); //데이터 통지 5개만

        Observable<Long> observable2 = Observable.interval(400L, TimeUnit.MILLISECONDS)
                .take(5)
                .map(num -> num + 1000);

        Observable.merge(observable1, observable2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(4000);
    }
}
