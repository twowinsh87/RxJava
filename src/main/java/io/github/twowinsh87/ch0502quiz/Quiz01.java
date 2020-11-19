package io.github.twowinsh87.ch0502quiz;

import io.github.twowinsh87.common.CarMaker;
import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {
    public static void main(String[] args) {

        Observable.fromIterable(SampleData.carList)
                .filter(car -> car.getCarMaker() == CarMaker.SSANGYOUNG)
                .subscribe(car -> Logger.log(LogType.DO_ON_NEXT, car.getCarName()));
    }
}
