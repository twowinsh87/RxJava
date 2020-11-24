package io.github.twowinsh87.ch0509;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableReduceExample03 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
//                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .reduce((x, y) -> "(" + x + ", " + y + ")")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
