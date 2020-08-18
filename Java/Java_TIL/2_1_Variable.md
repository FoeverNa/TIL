# 변수(Variable)

## 변수란

- 변수는 변하는 수를 뜻함

- 변수를 선언한다는 것은 변하는 값이 할당 될 수 있는 메모리의 공간을 확보하는 것


### 변수의 선언
```      
int x;
//자료형 변수명 으로 변수를 선언할 수 있다.
x = 10; // 10 -> 리터럴, 순수한 값을 리터럴이라고 부름, 있는 그대로의 값
//변수에 리터럴을 대입할 수 있다.
System.out.println(x); //10
      
int y, z, value; //변수는 여러개를 동시에 선언가능함
      
int valueOne = 10; //자료형 변수명 선언과 함께 값 대입가능
int valueTwo = 20; 
      
int valueThree = 100, valueFour = 1000; // 같은 자료형의 변수를 옆으로 늘여서 선언

```

### 변수명 규칙

- 변수를 선언할 때 변수명을 유의해서 선언해야 함

```
        //int int 
        int intOne; //int(자료형)는 변수명으로 사용불가 but int+@는 가능
        //int 4thword; // 숫자가 가장먼저 나올 수는 없음
        int val2ue1; // 숫자가 중간에는 가능
        int 한글_됩니다; // 한글은 쓸수있지만 사용하지말아라 강사님이 욕먹는데

        //int Three&Four; // &과 같은 특수문자 불가능
        int $power; // 그중 $는 가능하지만 특수한경우에만 사용하기에 쓰지마세요

        // Code Convention // 관습,관례

        int valueOfComputer; // 처음엔 소문자로시작하고 단어가바뀔떼마다 대문자사용 = camelCase= camelNotation
        // int PascalCase;//참고로 시작도 대문자 단어도 대문자하는것을 파스칼케이스
        int lowerCamelCase; // 카멜케이스
        int UpperCamelCase; // 파스칼케이스

        int _8thWord; //숫자먼저쓸땐 _(언더바)먼저 사용, 언더바는 특수문자 X

        //상수는 모두대문자로 STATIC_변수명(대문자), 위에 예시있음

````