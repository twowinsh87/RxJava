package io.github.twowinsh87.ch03;

import io.reactivex.Single;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SingleCreateExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> emitter.onSuccess(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(Calendar.getInstance().getTime())));

        single.subscribe(
                data -> System.out.println("data: " + data),
                error -> System.out.println("Error: " + error)
        );
    }
}
