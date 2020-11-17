package io.github.twowinsh87.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class test {

    public static class TimeUtil {

        public static long start;
        public static long end;
        final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        public static long start() {
            start = System.currentTimeMillis();
            System.out.println("바로 실행되는 start: " + start);
            return start;
        }

        public static void end() {
            end = System.currentTimeMillis();
        }

        public static void takeTime() {
            System.out.println("# 실행시간: " + (end - start) + " ms");
        }

        public static String getCurrentTimeFormatted() {
            return LocalTime.now().format(FORMATTER);
        }

        public static long getCurrentTime() {
            return System.currentTimeMillis();
        }

        public static void sleep(long interval) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("내가 start 호출: " + TimeUtil.start);
        System.out.println("내가 end 호출: " + TimeUtil.end);

    }
}
