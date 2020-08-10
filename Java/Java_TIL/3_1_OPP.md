#객체 지향 프로그래밍(Object Oriented Programming; OOP)

## 객체 지향 프로그래밍이란?
- 컴퓨터 프로그래밍 패러다임 중 하나(절대적인 것 아님)
- 기존의 절차지향 프로그래밍의 관점에서 벗어나 독립 단위인 객체의 모임으로 파악
  (각각의 객체가 있고 이 객체 들을 잘짜여지게 프로그래밍 함)
- 각각의 객체는 메세지를 주고받고(메세지의 종류는 다양함), 데이터를 처리 할수 있는 능력 있음
 (ex 이미지를 처리 객체, 통신을 위한 객체(서버, 클라이언트 객체)
 
## 객체 지향의 기본 구성 요소

클래스, 객체, 메서드


- 클래스 (class)(틀, 정의)
  - 같은 종류의 집단에 속하는 속성과 행위를 정의한 것
    - 값을 가지는 것이 아닌 정의를 하는 것, 실체가 아닌 실체를 만들기 위한 설계도 역할
    - 속성 : data , 행위 : data 를 어떻게 처리할 것인가
    - 같은 종류의 집단 : 같은 클래스에 속하는 여러 가지 물체가 존재할 수 있다.

  - 클래스는 다른 클래스 또는 외부 요소와 독립적으로 디자인해야 함
    - 다른 객체와 상호작용은 하지만 최대한 독립되게 만드는 것이 주요 철학(최대한 해당 객체만으로 동작할 수 있게 만듦)


- 객체(Object)(실체)
  - 클래스의 인스턴스로, 실제로 메모리 상에 할당 된 것
  
  - 자신(정의) 공유의 속성을 가지며, 클래스에 정의된 행위를 수행(행위=메서드)
    - 클래스에서는 정의가 되있다면 객체는 실체이기에 실제 그 행위를 할 수 있음

  - 객체와 클래스 예시
   
>사람이라는 클래스에 먹는다는 메서드가 있다면, 사람이라는 개념은 먹지못하지만 실제 존재하는 정한솔은 먹을 수있음
그리고 그외에 사람들은 똑같이 먹을 수 있다. 그리고 각각의 속성을 가진다.
배부르다는 속성이 있다면 각각의 행동에의해 결정됨
그러나 그걸 우리는 묶어서 사람으로 부를수 있다.
>

- 메서드(Method)(실체의 동작)

 - 클래스로부터 생성된 객체를 사용하는 방법(위 예시에서 행위)
 
 - 메소드는 한 객체의 속성을 조작하는 데에 사용(배고프다는 속성을 먹는다 행위로 변화를 주는 것처럼)


## 객체 지향의 특징 (객체지향에 집착을 해야함)

- OOP is A.P.I.E(갖추야할 것) oop는 a Pie이다 라고 읽음

   - Abstraction(추상화) : 자료 표현을 추상적으로 나타내는 추상 자료형을 사용함

   - Polymorphism(다형성) : 오버로딩과 오버라이딩을 하여 하나의 메소드명으로 다양한 동작을 구현할 수 있음
     - ex) println()에 입력값이 다양하게 올수 있는 것이 오버로딩 되어있기 때문

   - Inheritance(상속) : 부모 클래스로부터 속성과 메서드를 상속받아 사용할 수 있다.

   - Encapsulation(캡슐화) : 사용자에게 불필요한 정보를 은닉/ 보호해야 한다.
      - ex)사람의 여러 속성, 몸 무게 키 왼쪽 동공의 주름 등 / 근데 이 모든 것을 공개할 필요는 없음

   - 객체 지향을 배우면 세상에 많은 것이 객체 지향적으로 바라 보게 됨.() 그렇게 하나하나 개발자가되어가는 거래)