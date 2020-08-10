# 다형성 (Polymorphism)
 - 오버로딩에 의한 다형성
 - 오버라이딩에 의한 다형성
    - 상속에 의한 다형성
    
## 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징

```java 
 package s07.p01;
  
 class Foo {
     public void methodA() {
     }
 }
 
 class Bar extends Foo{
     public void methodB(){}
 }
 
 public class Poly01 {
     public static void main(String[] args) {
         Bar bar = new Bar(); // 자식 객체를 생성한 것
         Foo foo = (Foo)bar; // 부모 클래스 타입으로 자식 객체를 래퍼런스함
         // 여전히 힙 영역에는 자식 객체가 있습니다.
 
         foo.methodA();
         //foo.methodB();// 이 경우 자식 클래스 메소드는 사용이 불가능
         //문법적으로 사용이 불가. Foo 타입이기 때문에 자식객체이지만 문법적으로 제한이됨
 
         Foo foo1 = new Foo();
 //        Bar bar1 = (Bar)foo1; // 자식 클래스 타입으로 부모 객체를 받음
 //        문법오류X지만 실행시 오류가 발생(런타임 오류)
 //        bar1.methodA(); // 문법오류 x 애초에 성립이 안됨
 //        bar1.methodB(); // 문법오류 x
         // 문법적으로는 변수에 자식객체가 들어있는지 부모객체가 들어있는지는 알수가없음 => 그래서 문법ok
         // 위 아래 bar1은 문법적으로 똑같이 인식함
         // 자식 클래스 자료형으로 객체를 보려 하지만, 부모 객체 부분만 있기 때문에
         // 런타임에서 오류를 발생시킴 = > 실행은 됬지만 오류가 발생하는 상황(실행하기 위한 문법은 성립)
         // 클래스가  Bar > Foo 인 상황에서  Bar에 Foo를 대입을 하려고 하니까 빈부분이 생기고 에러가생김 => 정보부족
 
 
         Bar bar1 = (Bar)foo; // 자식 클래스 타입으로 자식 개체를 받음(원래있던자리로도랑옴)
         // 힙 영역에는 계속 자식 객체가 있었던 것.
         bar1.methodA();
         bar1.methodB();
 
         Foo foo2 = new Bar(); // 업캐스팅
         Bar bar2 = (Bar)foo2; // 다운캐스팅 => (Bar)안붙이면 에러발생
 
 
     }
 }
```
- 부모 클래스 타입으로 자식클래스의 객체를 생성한 경우
    - 부모 클래스의 메서드와 부모 클래스의 메서드를 오버라이딩한 메서드는 사용가능
    - 자식 클래스의 메서드는 사용 불가능
    - 부모 클래스의 변수에는 접근 가능
    - 자식 클래스의 변수에는 접근 불가
    
- 부모 클래스 타입으로 자식클래스의 객체를 생성한 경우 다시 자식 클래스 타입으로 형변환 할 수 있음
    - 상위 자료형에서 하위 자료형으로 옮기는 작업임으로 다운캐스팅 상황이어서 자료형을 붙여줘야함
        - Foo foo = new Bar(); Bar bar1 = (Bar)foo;
    - 위와 같이 형변환 하면 부모클래스의 메서드와 자식클래스 메서드 모드 접근가능
        - 타입에 상관없이 자녀객체는 유지하고 있었음을 의미함
    
- 자식 클래스 타입으로 부모클래스의 객체를 생성한 경우
    - 문법오류는 없어서 에러 안뜸 but 실행시 에러 발생(런타임 오류라고 함)
    - 부모 클래스의 메스더와 자녀 클래스의 메서드 문법오류 X, 실행오류 O
    - 자식 클래스의 유형으로 보려 하지만 부모 객체 부분만 있기 대문에 이러한 오류 발생
    - 자식 객체의 범위가 부모객체의 범위보다 넓기 때문에(포함관계) 정보부족에 의한 오류 발생
    
    
## 소제목을 뭐라고 할까


 - 멤버 변수의 재정의는 선언된 객체의 타입을 따른다. (문법적으로 본다)
 
 - 메소드 오버라이딩은 메모리상의 객체 타입을 따른다. (실제 객체로 본다)
    - (가상 메소드 호출; Virtual method call)

```java 
class Foo {
    static public String y = "Super Class";
    public String x = "Super";

    public void methodA(){
        System.out.println("Super Method");
    }
}

class Bar extends Foo {
    static String y = "Sub Class";
    public String x = "Sub";

    @Override
    public void methodA() {
        System.out.println("Sub Method");
    }
}
// 변수 x와 methodA둘다 오버라이드함

public class Ply02 {

    public static void main(String[] args) {
        Bar bar = new Bar();
        Foo foo = (Foo)bar;

        System.out.println(bar.x); //Sub
        bar.methodA(); // Sub Method

        System.out.println(foo.x); //Super
        // 멤버 변수의 재정의는 선언된 객체의 타입을 따른다(문법적으로 본다)

        foo.methodA(); //Sub Method
        // 메소드 오버라이딩은 메모리상의 객체 타입을 따른다.(실제 객채로 본다)
        // Foo에 있는 메소드는?
        // Virtual method call: 가상메소드 호출; 실제로 사용되지 않지만 호출되지는않음
        // 문법을 위해 호출이되어야되지(재정의된거니까)그러나 쓰이지는 않음

        System.out.println(Foo.y); // Super Class
        System.out.println(Bar.y); //Sub Class

        System.out.println(bar.y); // Sub Class
        System.out.println(foo.y); // Super Class
        // 스태틱 변수도 문법적으로 따라간다...
    }
}
```
- 부모 클래스 타입으로 자식클래스의 객체를 생성한 경우
    - 부모 클래스의 멤버 변수에 접근 가능하지만 자식 클래스의 변수에 접근 불가능하다
    - 부모 클래스의 메서드를 사용 가능하고 그 메서드를 자식 클래스가 오버라딩 한것 까지 사용 가능하다
    - 자식 클래스의 메서드는 사용이 불가능하다
    
- 자식 클래스가 부모클래스를 포함하고 있지만 문법적으로 부모클래스형을 따르기 때문에 부모클래스 범위만 사용가능하다

## 공변 반환 타입 (Convariant return type)

오버라이딩 특이사항


```java
package s07.p03;

class Foo {
    public Foo getInstance(){
        return this;
    }
}

class Bar extends Foo{
    @Override
    public Bar getInstance() {
        return this;
    }
    // public Foo getInstance(){ (Foo)getInstance()} 와 비슷하다...라는건가

    // 원래는 오버라이드할때 return타입도 같아야함, 그러나 이런경우는 예외적으로 인정을해줌
    // Foo에서 Foo를 return하나 Bar에서 Bar를 return 같은거라고 인식을 해준 거지지    // 오버로딩 아니고 오버 라이딩, 입력파라미터 같음
    // 공변반환타입 - 같이 변한다 CoVariant'
    // 리턴 타입은 클래스 밖에 들어갈게 없음 //
}

public class Poly03 {
}
```

- 보통 오버라이딩을 할 때 메서드의 구성(출력타입, 입력인자)을 변화시키지 않는다
    - 하지만 부모클래스가 부모클래스의 객체를 반환하는 메서드의 경우 자식클래스에서 오버라이딩시
        - 반환타입과 return을 자녀클래스와 자녀객체로 치환해주는데 이것을 공변반환타입이라고 한다.
            - 이는 자기자신의 객체를 출력하는 것으로 동일시 해주기 때문이다
                - 객체 이외의 return에는 적용되지 않는다.