package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample01 {
    public static void main(String[] args) {

        //flatmap 안에서 새로운 observable을 만들어서 여러개 데이터를 통지할 수 있음
        Observable.just("Hello")
                .flatMap(s -> Observable.just("자바", "파이썬", "안드로이드").map(lang -> s + ", " + lang))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
