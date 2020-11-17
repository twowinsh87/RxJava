package io.github.twowinsh87.ch03;

import io.github.twowinsh87.utils.DateUtil;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MaybeFromSingle {
    public static void main(String[] args) {
        //single class 의 just를 사용해서 데이터 한건을 통지하는 것으로 정의
        //maybe class 의 fromSingle 함수 사용하면 single 객체를 전달 받아서 Maybe class 객체 생성.
        //subscribe -> 즉 소비자 측 코드는 변하지 않는다.

        Single<String> single = Single.just(DateUtil.getNowDate());
        Maybe.fromSingle(single)
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.DO_ON_COMPLETE)
                );
    }
}
