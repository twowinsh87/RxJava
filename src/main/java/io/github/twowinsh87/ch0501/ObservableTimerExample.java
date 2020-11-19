package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {
    public static void main(String[] args){
        Logger.log(LogType.PRINT, "# Start!");
        Observable<String> observable =
                Observable.timer(2000, TimeUnit.MILLISECONDS) // 2초 딜레이하고. timer 함수는 독립적인 쓰레드에서 실행이 됨.
                        .map(count -> "Do work!"); //무언가 실행하고자 할 때 사용. ex) "Do work" 라는 문자열을 통지

        observable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000); //timer가 메인쓰레드에서 동작하지 않기 때문에, main Thread 에서 3초를 주어야 위에서 설정한 2초가 제대로 동작
    }
}
