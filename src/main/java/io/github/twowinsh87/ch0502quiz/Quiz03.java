package io.github.twowinsh87.ch0502quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Quiz03 {

    /**
     * interval, skipUntil, timer를 이용하여 1초에 한번씩 발행된 데이터 중에서 3초 후에 발행된 데이터만 10까지 출력하세요.
     * take도 넣어봄
     */
    public static void main(String[] args) {

        Observable.interval(1000L, TimeUnit.MILLISECONDS) //1초 단위로 발행함
                .take(8) // 8제외 즉 7까지 나옴
                .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS)) // 3초까지 통지 스킵
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(11500L );
    }
}
