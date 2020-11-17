package io.github.twowinsh87.ch03;

import io.reactivex.processors.PublishProcessor;

public class HotPublisher {
    public static void main(String[] args) {
        //Processor로 끝나면 HotPublisher로 볼 수 있음.
        PublishProcessor<Integer> processor = PublishProcessor.create();
        processor.subscribe(data -> System.out.println("구독자1: " + data));
        processor.onNext(1);
        processor.onNext(3);

        processor.subscribe(data -> System.out.println("구독자2: " + data));
        processor.onNext(5);
        processor.onNext(7);

        processor.onComplete();
    }
}
