# Wrapp 클래스(Wrapper class)

- 기본형 타입을 객체로 쓰기 위해 있는 클래스

- 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공
    - ex) 제너릭에 타입파라미터
    
 * byte -> Byte
 * char -> Character
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 
```java

public class WrapperClass {
    public static Integer add(Integer x, Integer y){ // Autoboxing
        return x+y; // Unboxing => 객체끼리 덧셈이 안되는데 자동으로 기본자료형으로 변형되서 계산
                    // return될때는 다시 출력형인 Integer로 Autoboxing이 이루어짐
    }

    public static <T> T bypass (T x){
        return x;
    } 

// T에는 원내 primitive 올 수 없음
//    public static <T> T add (T x, T y) {
//        return x + y;
//    } // 요거는 안됨 요거는 불편함 // 사칙연산에 대한 구현은 직접 해야함

    public static void main(String[] args) {
        Integer integer = new Integer(10); // 클래스니까 객체생성가능, 객체의 초기화값 입력하는방식
        Integer integer1 = Integer.valueOf(10); // Integer 클래스에 valueof 라는 스태틱메소드를 사용
                                                // 위에랑 똑같음

        Character character = new Character(('d'));
        Character character1 = Character.valueOf('f');

        // Autoboxing
        Integer integer2 =4; //바로 입력가능
        System.out.println(add(4,2)); // 6
                                // pimitive를 바로 Integer 타입으로 입력가능하도록 Autoboxing

        bypass(5); // autoboxing // 
      
        // 문자열 <-> 기본자료형
        int x = Integer.parseInt("100"); // pare+자료형 정적 메소드
                                            // String에서 primitive 타입으로 변환해주는 메서드
        int y = new Integer("100"); // 오버로딩이 되어있어서 String을 바로 입력받을 수 있다.
                                        // deprecated : 언젠가는 안쓰일문법이니 알아두라우
        int z = Integer.valueOf("200");
        System.out.println(z);
        // x가 가장 권장되는 방식

        //언박싱
        int m = new Integer(10);// 기본 자료형이 필요한 자리에 Wrapper class 객체가 있을 경우 자동으로 unboxing이 이루어짐
        // 객체로사용될대는 auto로사용 객체가 프리미티브되야될땐 unboxing

    }
}
```
## Wrapp 클래스 객체 생성
- new 키워드를 활용하여 객체 생성 가능
    ex)Integer integer = new Integer(10);

- valueOf()메서드를 활용하여 객체 생성 가능
    ex) Integer integer1 = Integer.valueOf(10);
    
- 기본 자료형 값을 바로 입력하여 객체 생성
     - Integer integer2 =4; ( Auto Boxing)
     
         
## 제너릭 타입 파라미터에 활용

- 제너릭 타입 파라미터에는 참조형 자료만 올 수 있고 기본 자료형은 올 수 없지만 Wrapper 클래스를 활용하여 기본 자료형을 입력할 수 있다
    - 메서드의 값을 입력하면 자료형을 자동으로 Autoboxing 해주어 해당 기본형의 객체를 생성해준다
    - bypass(5)를 입력시 new Integer(5)로 Autoboxing을 해주어서 제너릭 메서드에서 사용할 수 있게 된다
   
    
## Autoboxing 기본형 값을 Wrapper 클래스의 객체로 자동으로 변환시켜주는 것을 Autoboxing 이라고 한다
    - Integer integer = 4; => 4를 자동으로 Integer 객체로 만들어서 integer 변수에 집어넣음

- Wrapper 클래스의 객체를 자동으로 기본형 값으로 변환시켜주는 것을 Unboxing 이라고 한다
    - int m = new Integer(10); => Integer 객체를 int 로 자동 변환시켜서 4를 m에 집어넣음
    
    
## 문자열 <-->기본자료형

- 문자열로 입력된 값을 기본자료형으로 바꾸는 방법
    - Wrapper 클래스 parse+기본자료형()를 활용(제일 권장되는 방법)
        - int x = Integer.parseInt("100");
    
    - 기본자료형에 Wrapper 클래스 객체를 넣어서 Unboxing 하기
        - int y = new Integer("100");
        
    - Wrapper 클래스+ valueOf 메서드 활용하기    
        - int z = Integer.valueOf("200");