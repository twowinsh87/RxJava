package io.github.twowinsh87.ch0504;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public class ObservableToMapExample01 {
    public static void main(String[] args) {

        Single<Map<String, String>> single =
                Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
                        .toMap(data -> data.split("-")[0]); // 반환값은 Map의 key가 된다. 즉 a,b,c,e 가 key가 됨. value는 원본 데이터 =

        single.subscribe(map -> Logger.log(LogType.ON_NEXT, map));



//        Single<Map<String, String>> single = Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
//                .toMap(
//                        data -> data.split("-")[0], //key
//                        data -> data.split("-")[1]  //value
//                );
//
//        single.subscribe(map -> Logger.log(LogType.ON_NEXT, map));
    }
}
