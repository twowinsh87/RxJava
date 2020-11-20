package io.github.twowinsh87.ch0504;

import io.github.twowinsh87.common.Car;
import io.github.twowinsh87.common.CarMaker;
import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class ObservableGroupByExample01 {
    public static void main(String[] args) {
        //GroupedObservable<key, Type>
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList).groupBy(car-> car.getCarMaker()); //car 객체를 그룹으로 묶어주는데 Maker가 그룹을 묶는 키가 된다

        observable.subscribe(
                groupedObservable -> groupedObservable
                        .filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
                        .subscribe( car -> Logger.log( LogType.ON_NEXT, "Group: " + groupedObservable.getKey() + "\t Car name: " + car.getCarName())
        ));
    }
}
