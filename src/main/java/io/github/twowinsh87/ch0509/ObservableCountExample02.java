package io.github.twowinsh87.ch0509;

import io.github.twowinsh87.common.SampleData;
import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;

public class ObservableCountExample02 {
    public static void main(String[] args) {
        Observable.concat( //parameter를 차례차례 결합을 함.
                Arrays.asList(
                        Observable.fromIterable(SampleData.seoulPM10List),
                        Observable.fromIterable(SampleData.busanPM10List),
                        Observable.fromIterable(SampleData.incheonPM10List)
                )
        )
                .count()
                .subscribe(data-> Logger.log(LogType.ON_NEXT, data));
    }
}
