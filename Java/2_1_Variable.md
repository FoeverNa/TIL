# 변수(Variable)

## 변수란

- 변수는 변하는 수를 뜻한다. <=> 상수
- 변하는 값이 할당 될 수 있는 메모리의 공간 
  - 선언과 메모리 공간이 생성이 시점이 다를 수 있다는 것
- 변수를 선언한다는 것은 자료(Data)가 할당 될 수 있는 메모리의 공간을 확보하는 것이다
  - Java에서는 해당 변수의 어떤 자료가 들어갈 것인지 미리 자료형(Data Type)으로 표시한다
  - 표시한 자료형에 따라 해당 변수의 메모리의 크기가 결정된다 => ''자료형''에서 자세히 살펴보자

### 변수의 선언

- 변수는 자료형과 변수의 이름을 작성함으로 선언할 수 있다

  - 자료형은 변수의 메모리 크기를 결정하기 때문에 변수에 선언에서 반드시 입력해 주어야 한다
  - 변수명에 관한 규칙은 아래에서 더 자세히 살펴보자

  ```java
  int x; // int = 자료형, x = 변수명
  ```

- 선언된 변수에는 자료형에 맞는 자료(값)을 입력할 수 있다.

  - 변수에 자료(값)을 입력 할 때는 대입연사자 '='을 사용한다
  - 자료형에 따라 들어갈 수 있는 자료(값)에 대해서는 ''자료형'' 에서 배운다
    - x의 자료형은 int(정수) 자료형으로 정수 자료(값)이 들어갈 수 있다.

  ```java
  x = 10; 
  ```

- 같은 자료형의 변수는 여러개를 동시에 선언 할 수 있다.

  - 자료형을 작성하고 변수명을 콤마로 구분하여 작성 한다.

  ```java
  int y, z, value; //변수는 여러개를 동시에 선언가능함
  ```

- 변수의 선언과 동시에 값을 대입 할 수 있다

  ```java
  int valueOne = 10; //자료형 변수명 선언과 함께 값 대입가능
  int valueTwo = 20; 
  int valueThree = 100, valueFour = 1000; // 같은 자료형의 변수를 옆으로 늘여서 선언
  ```

  

#### 변수명 규칙

변수를 선언할 때 유의해야 할 변수명 규칙에 대해 알아보자

- 자바에 동륵된 의미가 약속되어 있는 예약어(키워드)는 사용할 수 없다

  - 자료형으로 쓰이는 int,double 등의 단어들이 대표적인 예약어 이다.

  ```java
   //int int //  예약어 int는 변수명으로 사용할 수 없음
   int intOne; //int(자료형)는 변수명으로 사용불가 but int+@는 가능
  ```

  

  

- 변수명을 숫자로 시작할 수 없다

  ```java
  //int 4thword; // 숫자가 가장먼저 나올 수는 없음
  int val2ue1; // 숫자가 중간에는 가능
  ```

  - 변수 명 중간에는 자유롭게 사용할 수 있다

    

- 한글 변수명을 사용할 수 있지만 사용하지 않는 것을 추천

  ```java
   int 한글_됩니다; // 한글은 쓸수있지만 사용하지말아라 강사님이 욕먹는데
  ```

- 특수문자는 특정한 것만 허용 된다

  ```java
  //int Three&Four; // &과 같은 특수문자 불가능
  int $power; // 그중 $는 가능하지만 특수한경우에만 사용하기에 쓰지마세요
  ```

- 그 외에 CodeConvetion

  - 변수명에는 camelCase를 사용한다

    - camelCase는 시작 단어는 소문자로 시작하고 단어가 바뀔때마다 대문자로 표기해주는 표기법이다

      ```java
      int valueOfComputer; // = camelCase= camelNotation
      ```

    - 참고로 모두 대문자로 표기하는 기법을 파스칼 케이스라고 한다

      ```java
      // int PascalCase;//참고로 시작도 대문자 단어도 대문자하는것을 파스칼케이스
      ```

  - 숫자를 먼저 쓸땐 '_' 를 사용한다

    ```java
    int _8thWord; //숫자먼저쓸땐 _(언더바)먼저 사용, 언더바는 특수문자 X
    ```

  - 상수를 표시할때는 모두 대문자를 사용하고 띄어쓰기는 '_'로 표기한다

    ```java
    static int STATIC_VRIABlE = 10;
    ```

- 실무에서는 이 모든 규칙을 다만족시킬 수는 없을 수 있지만 그래도 일관성을 가지고 있을 것이기에 그 일관성을 따라가야한다