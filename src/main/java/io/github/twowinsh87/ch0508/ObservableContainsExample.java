package io.github.twowinsh87.ch0508;

import io.github.twowinsh87.common.CarMaker;
import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

/**
 * 통지하는 데이터중에서 contains 조건에 맞기만하면 true
 */
public class ObservableContainsExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .contains(CarMaker.SAMSUNG) //true, fasle 한번만 통지하면되므로 Single 로 반환
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
