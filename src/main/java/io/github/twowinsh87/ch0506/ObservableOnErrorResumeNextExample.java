package io.github.twowinsh87.ch0506;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * onErrorResumeNext를 이용해서 에러 발생시, 다른 Observable로 대체하는 예제.
 */
public class ObservableOnErrorResumeNextExample {
    public static void main(String[] args) {
        Observable.just(5L)
                .flatMap(num -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> num / i)
                        .onErrorResumeNext(throwable -> {
                            Logger.log(LogType.PRINT, "# 운영자에게 이메일 발송: " + throwable.getMessage());

                            //최초 interval로 통지된거는 error가 발생했으므로 아래에서 다시 새로운 Observable을 발행함
                            return Observable.interval(200L,TimeUnit.MILLISECONDS).take(5).skip(1).map(i -> num / i);
                        })
                ).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
