package io.github.twowinsh87.ch0502;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableSkipExample {
    public static void main(String[] args) {

        //파라미터로 지정한 숫자, 시간동안 통지되지 않고 그 뒤의 데이터를 통지한다.
        Observable.range(1, 15)
                .skip(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        System.out.println("---------------------------------------------------------");

        Observable.interval(1000L, TimeUnit.MILLISECONDS) // 0 부터 1초 단위로 통지
                .skip(2000L, TimeUnit.MILLISECONDS) // 2초동안 건너뛰고 즉 데이터 0,1 건너뛰고 2를 통지
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data)); // 2만 받음

        TimeUtil.sleep(3000L);

    }
}
