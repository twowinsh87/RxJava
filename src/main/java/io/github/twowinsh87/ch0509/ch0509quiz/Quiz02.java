package io.github.twowinsh87.ch0509.ch0509quiz;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

/**
 * 10부터 1까지 역순으로 뺄셈한 최종 결과 값을 출력하세요.
 * 예) 10 - 9 - 8 - 7 - 6 - 5 - 4 - 3 - 2 - 1 = -35
 */
public class Quiz02 {
    public static void main(String[] args) {
        final int seed = 10;
        Observable.range(1, 9)
                .reduce(seed, (x, y) -> {
                    int b = seed-y;
                    Logger.log(LogType.PRINT, x + ", " + b);
                    return x - b;
                }).subscribe(data -> Logger.log(LogType.ON_NEXT, data));

    }
}
