package io.github.twowinsh87.ch0505;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.NumberUtil;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 랜덤 온도 데이터와 습도 데이터를 최신 데이터로 가져오는 예제
 */
public class ObservableCombineLatestExample02 {
    public static void main(String[] args) {
        // 랜덤 온도 데이터
        Observable<Integer> observable1 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                .take(10)
                .map(notUse -> SampleData.temperatureOfSeoul[NumberUtil.randomRange(0, 5)]);//interval로 생성되는 수는 사용하지 않음 = notuse

        // 랜덤 습도 데이터
        Observable<Integer> observable2 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                .take(10)
                .map(notUse -> SampleData.humidityOfSeoul[NumberUtil.randomRange(0, 5)]);

        Observable.combineLatest(observable1, observable2,
                (temperature, humidity) -> "최신 온습도 데이터 - 온도: " + temperature + "도\t습도: " + humidity + "%")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));


        /**
         * 온도, 습도가 통지될 때, 해당 시점에 최신 값을 찍는 것.
         */

        TimeUtil.sleep(3000L);
    }
}
