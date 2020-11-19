package io.github.twowinsh87.ch0502;

import io.github.twowinsh87.common.Car;
import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableTakeUntilExample01 {

    // 1. 파라미터로 지정한 조건이 true가 될 때까지 데이터를 통지
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList) //Iterable to Observable
                .takeUntil((Car car) -> car.getCarName().equals("트랙스")) //트랙스값이 나올때까지. 트랙스 포함
                .subscribe(car -> System.out.println(car.getCarName()));

        //TimeUtil.sleep(300L);
    }
}
