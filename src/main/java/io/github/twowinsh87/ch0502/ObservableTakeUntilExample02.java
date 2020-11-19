package io.github.twowinsh87.ch0502;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTakeUntilExample02 {

    public static void main(String[] args) {

        // 2. 파라미터로 지정한 Observable이 통지가 될 떄까지 데이터를 통지
        Observable.interval(1000L, TimeUnit.MILLISECONDS) //1초에 한번 데이터 통지
                .takeUntil(Observable.timer(5500L, TimeUnit.MILLISECONDS)) // 파라미터로 전달받은 Observable 데이터를 통지하기 전까지.
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(5500L);
    }
}
