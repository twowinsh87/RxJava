package io.github.twowinsh87.ch0503quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class Quiz01 {

    /** range, filter, map을 이용하여 1부터 15까지 숫자 중에 2의 배수만 필터링한 후, 필터링된 숫자에 제곱한 숫자를 출력*/
    public static void main(String[] args) {

        Observable.range(1,15)
                .filter(integer -> integer % 2 == 0)
                .map(result -> Math.pow(result, 2))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
