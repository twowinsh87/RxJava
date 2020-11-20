package io.github.twowinsh87.ch0504;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;

public class ObservableToListExample01 {
    public static void main(String[] args) {

        //toList이면 single로 반환됨
        Single<List<Integer>> single = Observable.just(1, 3, 5, 7, 9).toList();

        single.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        //Observable.just(1,3,5,7,9).toList().subscribe(data-> Logger.log(LogType.ON_NEXT, data));
    }
}
