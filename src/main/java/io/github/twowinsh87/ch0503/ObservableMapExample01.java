package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableMapExample01 {
    public static void main(String[] args) {
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7);
        Observable.fromIterable(oddList)
                .map(integer -> "1을 더한 결과: " + (integer + 1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
