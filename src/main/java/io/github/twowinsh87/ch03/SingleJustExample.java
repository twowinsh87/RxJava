package io.github.twowinsh87.ch03;

import io.reactivex.Single;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SingleJustExample {
    public static void main(String[] args) {
        Single.just(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(Calendar.getInstance().getTime()))
                .subscribe(
                        data -> System.out.println("data: " + data),
                        error -> System.out.println("Error: " + error)
                );
    }
}
