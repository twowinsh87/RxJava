package io.github.twowinsh87.ch0505.ch0505quiz;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quiz01 {
    public static void main(String[] args) {
/*
        Observable<Integer> observableDataA = Observable.fromIterable(SampleData.salesOfBranchA);
        Observable<Integer> observableDataB = Observable.fromIterable(SampleData.salesOfBranchB);
        Observable<Integer> observableDataC = Observable.fromIterable(SampleData.salesOfBranchC);

        Observable<Integer> flag = Observable.range(1, 12);

        Observable.zip(observableDataA, observableDataB, observableDataC, flag,
                (a, b, c, d) -> d + "월 합산 매출: " + (a+b+c))
                .subscribe(result -> Logger.log(LogType.ON_NEXT, result));
*/

        List<Observable<Integer>> salesList = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA),
                Observable.fromIterable(SampleData.salesOfBranchB),
                Observable.fromIterable(SampleData.salesOfBranchC)
        );

        Observable.zip(salesList, sales -> (int)sales[0] + (int)sales[1] + (int)sales[2])
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
