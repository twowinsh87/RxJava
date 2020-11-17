package io.github.twowinsh87.ch03;

import io.github.twowinsh87.utils.DateUtil;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Maybe;

public class MaybeLambdaExample {
    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());

            //emitter.onComplete();
        });

        maybe.subscribe(
                data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.DO_ON_COMPLETE)
        );
    }
}
