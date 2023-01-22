### 실습 내용
- kafka 브로커 서버를 구축한다.
- Spring Kafka Producer와 Spring Kafka Consumer를 구현한다.
- Producer에서 kafka서버에 message를 send해 보고
- Consumer에서 받아 출력해본다.


### Spring Kafka Producer

![Pasted image 20230122222116.png](images%2FPasted%20image%2020230122222116.png)
- kafkaTemplate을 통해 kafka 서버의 토픽에 메세지를 보낸다.
- 반환 값은 ListenableFuture타입인데, 해당 객체의 addCallback메서드를 사용하여 응답 값을 받아 처리해줄 수도 있다.

### Spring Kafka Consumer
![스크린샷 2023-01-22 오후 10.22.35.png](images%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-01-22%20%EC%98%A4%ED%9B%84%2010.22.35.png)
- hello2 토픽으로 kafka서버가 producer로부터 메세지를 전달 받으면, consumer가 해당 메세지를 consume한다.


### Spring Producer의 console화면
![스크린샷 2023-01-22 오후 10.13.06.png](images%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-01-22%20%EC%98%A4%ED%9B%84%2010.13.06.png)
partition은 총 2개로 구성되어 있어서 0과1이 번갈아 나오고,
메세지 하나당 offset이 1씩 증가하는 것을 볼 수 있다.



