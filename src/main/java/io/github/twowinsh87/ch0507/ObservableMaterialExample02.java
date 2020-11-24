package io.github.twowinsh87.ch0507;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

/**
 * Material/Dematerial 연산자의 실제 활용 예제
 * - 특정 Observable 에서 에러가 발생 할 경우 해당 에러에 대해서 구체적으로 처리할 수 있다.
 */
public class ObservableMaterialExample02 {
    public static void main(String[] args) {

        //concatEager는 observable을 순차로 결합하는데. 동시에 처리하고, 소비자에게 통지할 때는 파라미터 순으로 통지함
        Observable.concatEager(
                Observable.just(
                        getDBUser().subscribeOn(Schedulers.io()),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                //Notification을 넘겨서. 에러를 먼저 체크해서 에러처리를 하고
                                .materialize()
                                .map(notification -> {
                                    if (notification.isOnError()) {
                                        // 관리자에게 에러 발생을 알림
                                        Logger.log(LogType.PRINT, "# API user 에러 발생!");
                                    }
                                    return notification;
                                })
                                //에러가 난 notification 객체는 거르고
                                .filter(notification -> !notification.isOnError())
                                //소비자에게는 원본 origin=data만 들어있는 것을 통지
                                .dematerialize(notification -> notification)
                )
        ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(1000L);
    }

    private static Observable<String> getDBUser() {
        return Observable.fromIterable(Arrays.asList("DB user1", "DB user2", "DB user3", "DB user4", "DB user5"));
    }

    private static Observable<String> getAPIUser() {
        return Observable
                .just("API user1", "API user2", "Not User", "API user4", "API user5")
                .map(user -> {
                    if(user.equals("Not User"))
                        throw new RuntimeException();
                    return user;
                });
    }
}
