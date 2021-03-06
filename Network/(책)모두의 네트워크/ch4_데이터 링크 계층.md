# 데이터 링크 계층 : 랜에서 데이터 전송하기



## 데이터 링크 계층의 역할과 이더넷

### 데이터 링크계층

- 네트워크 장비 간에 신호를 주고 받는 규칙을을 정하는 계층

- 네트워트 기기 간에 데이터를 전송하고 물리주소를 결정한다

### 이더넷

- 랜에서 데이터를 정상으로 주고 받기 위한 규칙이다
  - 데이터 링크계층에서 가장 많이 사용되는 규칙
- 컴퓨터 네트워크 기술 중 하나로 전 세게의 사무실이나 가정에서 일반적으로 사용되는 랜에서 가장 많이 활용되는 기술 규격이다
- 허브에서 데이터 전송시 목적지 정보를 추가해서 목적지 의외의 컴퓨터는 데이터를 받더라도 무시하게하는 규칙이 있다
  - 허브는 데이터 전송시 모든 컴퓨터에게 보내는 특징이 있기 때문이다.

- 허브에서 여러 컴퓨터가 동시에 데이터를 전송해도 충돌이 일어나지 않는 구조로 되어 있다
  - 데이터가 동시에 케이블을 지나가면 충돌하기에 데이터를 보내는 시점을 늦추게 된다
  - 이러한 방식을 **CSMA/CD** 라고한다
- CSMA/CD
  - CS 데이를 보내려고 하는 컴퓨터가 케이블에 신호가 흐르고 있는지 아닌지를 확인한다
  - MA 케이블에 데이터가 흐르고 있지 않다면 데이터를 보내도 좋다는 규칙
  - CD 충돌이 발생하고 있는지를 확인하는 규칙
  - 효율이 좋지 못하기에 뒤에 나올 스위치로 대체되었다.





## MAC 주소의 구조

### mac 주소 (Media Access Control Address)

- 랜카드를 제조할 때 새겨지는 물리 주소로 전세계에서 유일한 번호가 할당 된다
- 48비트 숫자로 구성되며 앞쪽 24비트는 제조자 번호이고 뒤쪽 24비트는 제조사가 랜 카드에 붙인 일련번호이다
- 랜에 사용되는 네트워크 모델인 이더넷의 무리적인 주소로 컴퓨터 네트워크에서 각각의 기기를 구분하기 위해 사용되는 주소다

### 데이터 링크 계층에 헤더와 트레일러

- 데이터 링크 계층에서는 이더넷 헤더와 트레일러를 붙인다
- **이더넷 헤더**는 목적지 MAC 주소(6바이트), 출발지 MAC 주소(6바이트), 유형(2바이트) 총 14바이트로 구성된다
  - 이더넷 유형(Ethernet type)은 **프로토콜 종류를 식별하는 번호**로 이더넷으로 전송되는 상위 계층 프로트콜의 종류를 나타낸다.
  - IPv4, IPv6, ARP RARP, SNMP over Ethernet 이 있다
- 트레일러는 **FCS**(Frame Check Sequence)라고 하는데 데이터 전송 도중에 오류가 발생하는지 확인하는 용도로 사용한다
- 헤더와 트레일러가 추가된 데이터를 **프레임**이라고 한다

### 데이터 전송과정

- 컴퓨터 1~5가 하나의 허브에 연결되어 있고 각각의 MAC주소를 가지는 환경에서 컴퓨터 1이 컴퓨터3에게 메세지를 보내는 과정을 생각해보자
- 컴퓨터 1에서 데이터를 보내려고 하면 데이터 링크계층에서 프레임을 만들고 물리계층에서 이 프레임 비트열을 전기신호로 변환하여 네트워크를 통해 전송한다
- 허브는 해당 데이터를 하나의 포트로 수신하여 나머지 다른 모든 포트로 송신하는데 이때 수신한 컴퓨터에서 목적지 MAC주소가 자기 자신의 MAC주소가 다르다면 데이터를 파기 한다.
- 목적지 MAC주소와 동일한 컴퓨터 3은 전기신호를 받고 역캡슐화하여 데이터를 전달 받게 된다
- 만약 컴퓨터1이 데이터 전송할때 컴퓨터2가 동시에  컴퓨터 3으로 데이터를 전송하면 **충돌**을 방지하기 위해 CSMA/CD방식이 사용되 컴퓨터2가 잠시 대기하고 데이터를 다시 전송하게 된다.
- 충돌 : 데이터를 한 번에 하나만 전송할 수 있는 채널에 전송 장치 두 개가 같은 시점에 패킷을 보낼 때 일어나는 데이터 충돌을 말한다



## 스위치의 구조

### 스위치

- 데이터 링크 계층에서 동작하고 레이어 2 스위치 또는 스위칭 허브라고 블린다
- 랜을 구성할 때 사용하는 단말기 간 스위칭 기능이 있는 통신망 중계 장치다. 컴퓨터(호스트)에서 특정한 다른 단말기로 패킷을 보낼 수 있는 기능이 있어 통신 효율이 향상된다
- 스위치 내부에는 MAC 주소 테이블(MAC address table)이라는 것이 있다
  -  포터 번호에 연결되어 있는 컴퓨터의 MAC 주소가 등록되는 데이터베이스이다

#### MAC 주소 학습기능

-  목적지 MAC 주소가 추가된 프레임이라는 데이터가 전송되면 MAC주소 테이블을 확인하고 출발지 MAC 주소가 등록되어 있지 않으면 MAC 주소를 포트와 함께 등록한다

#### 플러딩

- 목적지 MAC 주소가 MAC 주소 테이블에 등록되어 있지 않으면 보내는 포트 외에 모든 포트에 데이터가 전송되는데 이러한 현상을 **플러딩** 이라고 한다
  
  - 목적지 MAC 주소가 MAC 테이블에 등록이 되어있다면 해당 주소로만 전송하게 된다
  
- MAC 주소를 기준으로 목적지를 선택하는 것을 **MAC 주소 필터링** 이라고 한다

  

## 데이터가 케이블에서 충돌하지 않는 구조

### 전이중 통신과 반이중 통신

#### 전이중 통신

- 데이터의 송수신을 동시에 통신하는 방식이다
- 전화 회선과 같이 송신과 수신이 양쪽에서 동시에 이루어지는 양방향 통신이다.  서로 다른 회선이나 주파수를 이용하여 데이터 신호가 충돌하는 상황을 방지한다.
- 데이터를 동시에 전송해도 문제없다
- 직접 랜 케이블을 연결하거나 스위치를 통해 연결하면 전이중 통신을 하게 된다

####  반이중 통신

- 회선 하나로 송신과 수신을 번갈아가면서 통신하는 방식이다
- 데이터를 동시에 전송시 충돌이 발생한다
- 허브를 사용하면 반이중 통신 방식을 사용하게된다

### 충돌 도메인

- 데이터 충돌이 발생하고 그 충돌 영향이 미치는 범위를 충돌 도메인이라고 한다.

- 허브의 경우 연결 되어있는 전체 컴퓨터가 충돌도메인이 된다

- 스위치의 경우는 충돌이 일어나지 않고 충돌 도메인의 범위도 각 개별 컴퓨터로 한정된다

- 충돌 도메인이 넓을수록 네트워크 지연이 발생한다

  



## 이더넷의 종류와 특징

### 이더넷 규격

| 규격 이름  | 통신 속도 | 케이블               | 케이블 최대 길이 | 표준화 연도 |
| ---------- | --------- | -------------------- | ---------------- | ----------- |
| 10BASE5    | 10Mbps    | 동축 케이블          | 500m             | 1982년      |
| 10BASE2    | 10Mbps    | 동축케이블           | 185m             | 1988년      |
| 10BASE-T   | 10MBPS    | UTP케이블(Cat3이상)  | 100m             | 1990년      |
| 100BASE-TX | 100Mbps   | UTP케이블(Cat5이상)  | 100m             | 1995년      |
| 1000BASE-T | 1000Mpbs  | UTP케이블(Cat5이상)  | 100m             | 1999년      |
| 10GGBASE-T | 10Gbps    | UTP케이블(Cat6a이상) | 100m             | 2006년      |

- 앞에있는 숫자 : 통신 속도
- BASE: BASEBAND라는 전송방식
- T : 케이블 종류
- 하이픈(-)이 붙은것은 케이블 종류를 나타낸다
  - 동축케이블은 하이픈 없이 케이블의 최대길이를 표시한다
- Catx이상 : UTP케이블의 분류, 속도에 따라 나뉜다.



## 보강

### ARP(Address Resoultion Protocol)

- 네트워크 계층 주소와 데이터 링크 계층 주소사이의 변환을 담당하는 프로토콜이다. IP 주소를 물리 주소인 MAC 주소로 변환하는 데 사용한다
- 목적지 컴퓨터의 IP 주소를 이용하여 MAC 주소를 찾기 위한 프로토콜이다
  - 이더넷 프레임을 전송하려면 목적지 컴퓨터의 MAC 주소를 지정해야 한다
- ARP 요청 : 출발지 컴퓨터에서 목적지 주소를 모를 때 네트워크에 브로드캐스트를 하는 것을 뜻한다
- ARP 응답 : APR 요청에 대해 지정된 IP주소를 가진 컴퓨터는 MAC주소를 응답으로 보내는 것을 뜻한다
- ARP 테이블 : MAC주소와 IP주소의 매핑 정보를 메모리에 보관하는 곳을 이른다
  - IP주소가 변경되면 해당 MAC주도소 변경되기때문에 ARP 테이블에서는 보존 기간을 ARP 캐시로 지정하고 일정 기간이 지나면 삭제하고 다시 ARP 요청을 한다