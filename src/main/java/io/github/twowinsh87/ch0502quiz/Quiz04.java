package io.github.twowinsh87.ch0502quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class Quiz04 {

    public static void main(String[] args) {

        Observable.range(1, 15)
                .skipLast(3) //마지막 3개를 버림(13,14,15)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
