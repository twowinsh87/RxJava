package io.github.twowinsh87.ch0509;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableReduceExample02 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnNext(data -> Logger.log(LogType.ON_NEXT, data))
                //seed라고 초기 파라미터 값을 넣을 수 있음. seed로 지정한 값이 0이고, 첫 y는 just 의 첫번째 데이터
                .reduce(0, (x, y) -> {
                    Logger.log(LogType.PRINT, "# reduce 한 값 : " + x + "+" + y);
                    return x + y;
                }).subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
