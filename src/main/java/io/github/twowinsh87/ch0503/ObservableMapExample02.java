package io.github.twowinsh87.ch0503;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

public class ObservableMapExample02 {
    public static void main(String[] args) {
        Observable.just("korea", "america", "canada", "paris", "japan", "china")
                .filter(s -> s.length() == 5)
                .map(s -> s.toUpperCase().charAt(0) + s.substring(1))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
