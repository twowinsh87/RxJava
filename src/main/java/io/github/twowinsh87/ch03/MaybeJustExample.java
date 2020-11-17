package io.github.twowinsh87.ch03;

import io.github.twowinsh87.utils.DateUtil;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Maybe;

public class MaybeJustExample {
    public static void main(String[] args) {
        //데이터 1건 통지 just
        Maybe.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.DO_ON_COMPLETE)
                );

        //데이터 통지 없이 완료만 통지. () -> Logger.log(LogType.DO_ON_COMPLETE) OnComplete 호출되는지 확인
//       Maybe.empty()
//                .subscribe(
//                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜시각: " + data),
//                        error -> Logger.log(LogType.ON_ERROR, error),
//                        () -> Logger.log(LogType.DO_ON_COMPLETE)
//                );
    }
}
