package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * switchMap을 이용한 효율적인 키워드 검색 예제
 */
public class ObservableSwitchMapExample03 {

    public static void main(String[] args) {
        TimeUtil.start();
        Searcher searcher = new Searcher();

        final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .switchMap(data -> { /** switchMap을 사용했기 때문에 마지막 키워드를 사용한 최신 검색 결과만 가져온다 */
                    String keyword = keywords.get(data.intValue());

                    return Observable.just(searcher.search(keyword))
                            .delay(1000L, TimeUnit.MILLISECONDS);

                })
                .flatMap(resultList -> Observable.fromIterable(resultList))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {},
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        }
                );
        TimeUtil.sleep(2000L);
    }
}
