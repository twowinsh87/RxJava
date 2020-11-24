package io.github.twowinsh87.ch0508;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 여러개 Observable 중에서 통지시점이 가장 빠른 녀석만 통지.
 */
public class ObservableAmbExample {

    public static void main(String[] args) {
        List<Observable<Integer>> observables = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA)
                        .delay(200L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch A's sales")),
                Observable.fromIterable(SampleData.salesOfBranchB)
                        .delay(300L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch B's sales")),
                Observable.fromIterable(SampleData.salesOfBranchC)
                        .delay(500L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# branch C's sales"))
        );

        //위에서 0.2초마다 통지하는 BranchA 데이터만 최종적으로 통지가 될 것.
        Observable.amb(observables) //parameter Iterable
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE, "# 완료"))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(1000L);
    }
}
