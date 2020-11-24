package io.github.twowinsh87.ch0508;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

/**
 * 통지되는 데이터가 없을 경우, 디폴트 값을 통지하는 예제
 */
public class ObservableDefaultIfEmptyExample {
    public static void main(String[] args) {
        //최종적으로 완료를 통지하게되는데 데이터가 통지된 것이 없다면, defaultIfEmpty의 파라미터로 전달된 데이터를 통지한다.
        Observable.just(1, 2, 3, 4, 5)
                .filter(num -> num > 10)
                .defaultIfEmpty(10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
