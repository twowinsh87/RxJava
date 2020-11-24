package io.github.twowinsh87.ch0505;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample01 {
    public static void main(String[] args) {
        Observable<Long> observable1 =
                Observable.interval(500L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.don("# observable 1 : " + data))
                        .take(4);

        Observable<Long> observable2 =
                Observable.interval(700L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.don("# observable 2 : " + data))
                        .take(4);

        Observable.combineLatest(
                observable1,
                observable2,
                (data1, data2) -> "data1: " + data1 + "\tdata2: " + data2 + "\tsum: " + (data1+data2))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000L);
    }

}
