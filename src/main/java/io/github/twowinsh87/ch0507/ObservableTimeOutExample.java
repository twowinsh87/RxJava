package io.github.twowinsh87.ch0507;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimeOutExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .map(data -> {
                    long time = 1000L;
                    if(data==4) {
                        time = 1500L;
                    }
                    TimeUtil.sleep(time);
                    return data;
                })
                .timeout(1200L, TimeUnit.MILLISECONDS) // 통지 기준으로 1.2초 안에 통지가 안되면 error 를 발행
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_NEXT, error)
                );
    }
}
