package io.github.twowinsh87.ch0504.ch0504quiz;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .toMap(
                        key -> key.getCarName(),
                        value -> value.getCarMaker()
                ).subscribe(mapData -> Logger.log(LogType.ON_NEXT, mapData));
    }
}
