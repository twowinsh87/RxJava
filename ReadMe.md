### RxJava 목적
- Java 비동기 구현
- Reactor, WebFlux 의 기본
- kevin님 강의


### 참고
- [리액티브 프로그래밍의 공식 사이트](https://rxmarbles.com/)
- [마블다이어그램](https://rxmarbles.com/)
- [리액티브 한국어 번역자료](https://gist.github.com/casamia918/93b8db69beb9ee06b92a96b2a234d48e)
- [ Reactive Streams의 스펙을 정의](https://github.com/reactive-streams/reactive-streams-jvm)
- [RxJava 공식](http://reactivex.io/RxJava/2.x/javadoc/)

### 1.Hello Java

### 2.Reactive Streams
- 리액티브 프로그래밍에 대한 표준 인터페이스만 제공
- Reactive Streams 인터페이스를 구현한 구현체 = RxJava
- `Publisher` : 데이터를 생성하고 통지
    - subscribe(필수) : 데이터를 구독함
- `Subscriber` : 통지된 데이터를 전달받고 처리
    - onSubscriber : 데이터를 통지할 준비가 되었음을 알림
    - onNext : 요청 받은 개수만큼 데이터를 알림
    - onError
    - OnComplete
- `Subscription` : 전달 받을 데이터의 개수를 요청하고 구독을 해지
    - request : 전달 받을 통지 데이터 개수를 요청
    - cancel
- `Processor` : Publisher 와 Subscriber 의 두 기능을 가지고 있음


#### Cold Publisher
- 소비자는 구독 시점과 상관없이 통지된 데이터를 처음부터 전달 받을 수 있음
- 생산자는 소비자가 구독 할때마다 데이터를 처음부터 새롭게 통지

#### Hot Publisher
- 소비자는 구독 시점에 통지된 데이터들만 전달 받을 수 있음
- 생산자는 소비자의 수와 상관없이 데이터를 한번만 통지


### 3.Flowable vs Observable
- [소스코드 참고](https://github.com/ITVillage-Kevin/rxjava/tree/master/src/main/java/com/itvillage/chapter03/chapter0302)

#### Flowable
- package org.reactivestreams;
- 리액티브 streams 인터페이스 구현
- Subscriber에서 데이터를 처리
- 데이터 개수를 제어하는 `배압(back pressure) 기능` 이 있음 = 데이터 개수 제어 가능
- Subscription으로 구독을 해지

#### Observable
- package io.reactivex;
- 리액티브 streams 인터페이스 구현하지 않음. Rxjava 에서 제공 
- Observer 에서 데이터를 처리
- 데이터 개수를 제어하는 `배압(back pressure) 기능` 이 없음 = 데이터 개수 제어 불가
- Dispasable로 구독을 해지 


#### 배압기능 & RxJava의 배압 전략
- Flowable에서 데이터를 통지하는 속도 > Subscriber에서 데이터를 처리하는 속도
    - 균형을 맞추기 위해서 데이터 통지량을 제어하는 기능
- 왜 통지량을 맞춰야 하는가?
    - 균형이 맞지 않고, 통지된 데이터가 대기하는 상황이 발생하면 에러가 발생할 수 있음
    
- Missing 전략
    - 배압을 적용하지 않는다
    - 추후에 onBackpressureXXX() 로 배압 적용을 할 수 있음

- ERROR 전략
    - 통지된 데이터가 버퍼의 크기를 초과하면 MissingBackpressureException 에러를 뱉음

- BUFFER 전략
    - DROP_LATEST 전략: 버퍼가 가득 찬 시점에 버퍼 내에서 가장 최근에 들어온 데이터를 DROP
    - DROP_OLDEST 전략: 버퍼가 가득 찬 시점에 버퍼 내에서 가장 나중에 들어온 데이터를 DROP
    
- Drop 전략
    - 소비자 쪽에서 처리하기 전에 들어온(통지된) 데이터는 모두 drop
    
- LATEST 전략
    - 소비자 쪽에서 처리하기 전에 들어온(통지된) 데이터 중에서 가장 나중에(최신) 데이터를 가져와 처리
    - 버퍼가 가득차면 이 후에 통지된 데이터는 버퍼 외부에서 대기하고 있고, 가장 최근데 대기하는 데이터 부터 버퍼에 채워진다.
    - ex) 외부 [8,7,6] buffer [5,4,3,2,1] 이 때, 1~5 통지 데이터 처리 후, 시점에 8이 가장 나중이라면
        - 7,6 은 버려지고 buffer [10,9,8] 이 담기게 됨 