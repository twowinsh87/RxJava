package io.github.twowinsh87.ch0502;

import io.github.twowinsh87.common.CarMaker;
import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));

        System.out.println("---------------------------------------------------------");

        Observable.fromArray(SampleData.carMakersDuplicated)
                .distinct()
                .filter(carMaker -> carMaker == CarMaker.SSANGYOUNG)
                .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));

        System.out.println("---------------------------------------------------------");

        Observable.fromIterable(SampleData.carList)
                .distinct(car -> car.getCarMaker())
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
