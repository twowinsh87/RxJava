package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample02 {
    public static void main(String[] args) {

        Observable.range(2, 1)
                .flatMap(
                        num -> Observable.range(1, 9)
                                .map(row -> num + " * " + row + " = " + num * row)
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
