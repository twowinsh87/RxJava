package io.github.twowinsh87.ch03;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class CompletableLambdaExample {
    public static void main(String[] args) {
        Completable completable = Completable.create(emitter -> {

            int sum = 0;

            for(int i=0; i<100; i++) {
              sum += i;
            }
            Logger.log(LogType.PRINT, "# 합계: " + sum);

            emitter.onComplete();
        });

        //subscribeOn은 생산자쪽에서 통지용 Thread 를 따로 뺄 수 있다.
        completable.subscribeOn(Schedulers.computation())
                .subscribe(
                        () -> Logger.log(LogType.DO_ON_COMPLETE),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );

        TimeUtil.sleep(100L);
    }
}
