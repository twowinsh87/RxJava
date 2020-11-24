package io.github.twowinsh87.ch0505;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.github.twowinsh87.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * 3개의 Observable에서 통지된 순서와 상관없이 Observable이 concat( )에
 * 입력된 순서대로 각 구간의 차량 속도 데이터를 이어 붙여 출력하는 예제
 */
public class ObservableConcatExample02 {
    public static void main(String[] args) {
        List<Observable<String>> speedPerSectionList = Arrays.asList(
                SampleData.getSpeedPerSection("A", 55L, SampleData.speedOfSectionA),
                SampleData.getSpeedPerSection("B", 100L, SampleData.speedOfSectionB),
                SampleData.getSpeedPerSection("C", 77L, SampleData.speedOfSectionC)
        );

        Observable.concat(speedPerSectionList) //concat은 iterable 가능
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(2000L);
    }
}
