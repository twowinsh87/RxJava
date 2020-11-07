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

### Hot Publisher
- 소비자는 구독 시점에 통지된 데이터들만 전달 받을 수 있음
- 생산자는 소비자의 수와 상관없이 데이터를 한번만 통지