package io.github.twowinsh87.ch0506;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    private final static int RETRY_MAX = 5;
    public static void main(String[] args) {
        Observable.just(5)
                .flatMap(
                        num -> Observable
                                .interval(200L, TimeUnit.MILLISECONDS)
                                .map(i -> {
                                    long result;
                                    try{
                                        result = num / i;
                                    }catch(ArithmeticException ex){
                                        Logger.log(LogType.PRINT, "error: " + ex.getMessage());
                                        throw ex;
                                    }
                                    return result;
                                })
/*                                .retry((retryCount, ex) -> { //retryCount가 1부터 증가하게 됨
                                    Logger.log(LogType.PRINT, "# 재시도 횟수: " + retryCount);
                                    TimeUtil.sleep(1000L); //클라이언트 요청에 따른 서버쪽에 처리시간을 강제로 주기위해서 임의로 추가함
                                    return retryCount < RETRY_MAX ? true : false;
                                })*/
                                .retry(5)
                                .onErrorReturn(throwable -> -1L)
                ).subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> Logger.log(LogType.ON_ERROR, error),
                () -> Logger.log(LogType.ON_COMPLETE)
        );

        TimeUtil.sleep(5000L);
    }
}
