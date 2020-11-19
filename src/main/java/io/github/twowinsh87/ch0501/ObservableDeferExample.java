package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

import java.time.LocalTime;

public class ObservableDeferExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observable = Observable.defer(() -> {
            LocalTime currentTime = LocalTime.now();
            return Observable.just(currentTime);
        });
        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독1의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독1의 구독 시간: " + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독2의 구독 시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독자2의 구독 시간: " + time));

        //Just는 발행된 시점에 전달받은 시간을 찍고, defer는 새로운 구독이 발생할 때 시간을 찍음
    }
}
