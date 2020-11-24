package io.github.twowinsh87.ch0509;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableCountExample01 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .count()
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
