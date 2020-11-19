package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample03 {

    /**
     * FlatMap 두번째 유형을 이용한 구구단의 2단 출력 예제
     * 원본 데이터 + 변환된 데이터 = 최종데이터 반환
     */
    public static void main(String[] args) {
        Observable.range(2, 1)
                .flatMap(
                        data -> Observable.range(1, 9),
                        //sourceData=원본, transformedData=range로 변환된 Observable 데이터
                        (sourceData, transformedData) ->
                                sourceData + " * " + transformedData + " = " + sourceData * transformedData
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
