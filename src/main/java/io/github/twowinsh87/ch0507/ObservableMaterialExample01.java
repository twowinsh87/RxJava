package io.github.twowinsh87.ch0507;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableMaterialExample01 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                .materialize()
                .subscribe(notification -> {

                    //통지 타입을 isOnNext, inOnError 함수를 통해서 확인
                    String notificationType =
                            notification.isOnNext() ? "onNext()" : (notification.isOnError() ? "onError()" : "onComplete()");

                    Logger.log(LogType.PRINT, "notification 타입: " + notificationType);
                    Logger.log(LogType.ON_NEXT, notification.getValue());
                });
    }
}
