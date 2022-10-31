# [ Service 위임, 책임 분리에 대한 실습 ]

## API Layer 와 Domain Layer 의 service 책임 분리

### [요건]

- REST API 를 통해서 주식 정보를 불러온다.
- 주식이라는 도메인이 존재. (Stock)
- (주식은 시작가와 종가가 있다.)
- 주식은 현재가가 있어 실시간으로 업데이트 해와야 한다. -> Redis
- 현재가와 시작가를 비교해서 등락율을 구해야 한다. -> Logic


[기존구조]  
Controller  
Service - deliver & manufacture -> 가져오고 나서 변환 -> test 어려움 -> 완성도있는 프로덕트가 안나옴  
Repository


[서비스 책임 분리]  
Controller (B')  
Presentation Layer Service (A -> B') - manufacture  
----------------------- Service 간의 전송객체  
Domain Layer Service (A) - deliver  
Repository (A)


## [TIP]

1. 함수가 가져야할 책임? - 스멜이 나는 코드인가? 너무 많은 역할과 책임이 있는게 아닌가?
2. 그렇다면 이 함수가 몰라도 되는 것은 무엇인가?
3. 몰라도 된다면 다른 서비스에 넘겨보자
4. 넘겼는데 모양이 개선이 안되는 느낌이다. 혹은 스코드가 깨진다.
5. 서비스간에 메세지를 주고받을 중간객체를 만들어보자.

# [ 멀티모듈을 통한 책임 분리 ]

하나의 모놀리틱 구조에서 소스레벨에서의 역할/책임 -> 각 역할에 맞는 서비스로 구성 -> 각 서비스 간에 역할/책임


API
 |
DOMAIN (공통으로 쓰일 모듈)
COMMON (configuration, objectMapper Provider, Util, Log, MultimoduleException)
MultimoduleException -> AOP

DOMAIN -> 모든 곳에서 공통으로 쓰임  
client 는 Domain 외에 api, kafka 몰라도 됨  
kafka -> api, client 몰라도 됨  

=> 책임분리는 알겠는데 왜 함?? 모놀리틱으로도 충분했는데  

MSA -> 각 서비스들이 인스턴스화되서 따로 동작  
 
모놀리틱 -> 일부수정 => 전체 다 배포  
멀티모듈 -> 일부수정 => 수정한 것만 배포 => 서비스 간에 커플링 내려감  

이슈대응이 편해짐.  
트랙픽이 몰림 => Scale out  
모놀리틱 -> api 만 늘어나면 되는데, 다른 것까지 다 늘어남.   

멀티모듈 -> API Scale out, Client Scale out   

Kafka  
- refresh topic, 여기에 유저 id 가 들어오면 -> 합산 금액 -> producing  
=> 여기에 + 우리데이터 바뀔때마다 producing  