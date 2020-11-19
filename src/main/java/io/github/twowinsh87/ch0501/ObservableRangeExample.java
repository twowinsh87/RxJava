package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableRangeExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(0,5);
        source.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
    }
}
