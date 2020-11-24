package io.github.twowinsh87.ch0507;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableDelayExample02 {
    public static void main(String[] args) {

        Observable.just(1,3,5,7)
                .delay(item -> {
                    TimeUtil.sleep(1000L); //일정한 지연을 시킨 후
                    return Observable.just(item); //소비자에 통지
                }).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
