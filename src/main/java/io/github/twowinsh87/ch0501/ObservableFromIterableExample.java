package io.github.twowinsh87.ch0501;

import io.github.twowinsh87.utils.LogType;
import io.github.twowinsh87.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Korea", "Japan", "USA");

        Observable.fromIterable(countries)
                .subscribe(country -> Logger.log(LogType.DO_ON_NEXT, country));
    }
}
