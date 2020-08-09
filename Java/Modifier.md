# 제어자 (Modifier)

## 제어자란?

- 클래스, 변수, 메소드에 부가기능을 부여하는 키워드
- 접근제어자(Access modifiers)
  - 접근할 수 있는 범위를 정하는 키워드
  - public, protected, (default = pakage), private 

- 그외 제어자(other modifiers)
 - 특별한 기능을 부여하는 제어자
 - static, final, abstract, synchronized

## 제어자의 기능

### 접근제어자
 - 접근 가능한 범위를 정해, 데이터 은닉/보호(Encapsulation)기능을 추가한다.
   - 인캡이 필요없으면 다 public하면 되겠지, 근데 편의성보다는 은닉하는게 더 좋은점이 많기에 사용됨
 - 접근제어자별 접근 범위(public > protected > default > private)

   - public  - 같은 클래스 / 같은 패키지(폴더)/ 다른패키지에 속한 자식 클래스(예를보자) / 전체(어디서든)
   - protected - 같은 클래스 / 같은 패키지/ 다른패키지에 속한 자식 클래스(자식까지만)(자식에 자식은 접근이안됨)
   - default - 같은 클래스 / 같은 패키지(다른패키지 자식은 볼수가 없음)
   - private - 자기자신, (자식도 볼수 없음)
   
 - private 또는 protected 변수에 외부에서  접근하기 위해 앞에서 배운 getter와 sette 사용함

- 코딩 실습1

 ```java
 
 package s04.p05.subp01;
 
 public class ClassA {
     public int x;
     protected  int y;
     int z; // default(= package)
     private int w;
 
     public void methodA() {}
     protected  void methodB() {}
     void methodC() {} // default(=package)
     private void methodD(){}
 
     public void methodTest(){
         System.out.println(x);
         System.out.println(y);
         System.out.println(z);
         System.out.println(w);// 내부라 접근가능
 
         methodA();
         methodB();
         methodC();
         methodD(); // 내부이기에 접근 가능
 
         //private은 특성상 내부 구현을 위해서만 사용됨
     }
     
 
 }
 
 
 class ClassTest { // 같은 패키지인 경우우
     public static void main(String[] args) {
         ClassA obj = new ClassA();
         System.out.println(obj.x);
         System.out.println(obj.y);
         System.out.println(obj.z);
         //System.out.println(obj.w); // w는 private이라 접근 불가
 
         obj.methodA();
         obj.methodB();
         obj.methodC();
         // obj.methodD(); // 접근 불가 /IDE 빠른완성에 뜨지도 않음
     }
 
 }
 ```

- 같은 패키지의 같은 클래스의 경우 모든 접근제어자에 접근이 가능함
- 같은 패키지의 다른 클래스의 경우 private 접근제어외에 다른 접근자에는 접근이 가능함

- 코딩 실습2
```java
package s04.p05.subp02;
import s04.p05.subp01.ClassA;


class ClassAA extends ClassA {

    public void methodTest(){
        System.out.println(x);
        System.out.println(y); // 자식이라 다른 패키지에서도 사용 가능
        //protected는 private처럼 쓰지만, 상속한 경우 접근이 필요 할 때 사용함(내부적 구현 바꾸어야 할때)
        //System.out.println(z); // 접근불가
       // System.out.println(w);// 내부라 접근가능

        methodA();
        methodB();
//        methodC(); 접근불가
//        methodD(); // 내부이기에 접근 가능

        //private은 특성상 내부 구현을 위해서만 사용됨

        //protect나 prviate은 어떤걸 써도 상관이 없는 경우가 많다.
        //개발철학에 따라서 달리지는 경우라 이때는 이걸써야한다는 정해진것은 없음
        //protected에 변수를 상속받아서 쓰면 private이됨// 자식의 자식은 건들수가 없음
        // 아리송한것은 어쩔수없음 어떤미친넘이 이걸 private으로놧냐하면서 현업자도 싸움..ㅋㅋㅋ
        // 다만 어떤 접근제어자를 어떻게 접근할 수있는지 알아서 다른사람에 코드에 접근할수 있으면 됨

        //클래스에서는 public
        //default는 이미 사용하고 있음
        //protected  private는 전제가 말이안됨 // 이해못햇는데 한번천천히 따져보자
    }
}

public class ClassB {

    public static void main(String[] args) {
        ClassA obj = new ClassA();
        System.out.println(obj.x);
        // System.out.println(obj.y); //protected는 다른 패키지인 경우 자식만 가능
        // System.out.println(obj.z); // default는 다른 패키지면 안됩니다.
        //System.out.println(obj.w); // w는 private이라 접근 불가

        obj.methodA();
        //obj.methodB();
        // obj.methodC();
        // obj.methodD(); // 접근 불가 /IDE 빠른완성에 뜨지도 않음
    }
}
```
- 다른 패키지에 해당클래스를 상속받은 클래스는 public과 protect만 접근이 가능함
- 다른 패키지에 상속받지 않는 보통의 클래스의 경우 public으로만 접근이 가능함

- 위의 예제에서 처럼 접근제어자 키워드 별로 접근이 가능한 범위를 지정해 줄 수 있음

#### 참고사항  : 클래스명이 public class와 같은 이유
- java 파일에는 무조건 하나의 클래스가 있기로 약속을 했고 하나의 클래스명은 파일이름과 같아야 한다는 규칙이있음
- 해당 public 클래스는 전체 클래스를 대표해서 다른 클래스들에서 불러서 사용할 수 있게 됨
- 그 외에 전체에 존재하는 다른 클래스는는 내부적으로 대표클래스를 구성하는 클래스로 인식을하게 됨

#### 싱글톤 패턴(Singletone)

- private 키워드를 활용해 객체가 단 하나만 존재할 수 있는 클래스를 만드는 패턴
- 언제사용하는지 보충 필요
- 싱클톤 패턴 예시
```java
class SingletonClass {
  private static SingletoneClass instance = new SingletonClass();
  private SingletonClass() {}

  public static SingletonClass getInstance() {
      return instance;
  }
}
```

### 그 외의 제어자

- final 
  - 더 이상 바뀔수 없음을 의미
  - 클래스 : 더이상 상속이 불가능해진다.  
  - 메소드 : 자식클래스에서 더이상 오버라이드할수 없음(재정의할수없음)
  - 변수 : 초기화한 뒤에 값이 변하지 않음.
     - 클래스에서 초기환한겨우 fianal variable이고
     - 생성자에서 초기화한경우는 blank fianl vriable이라고한다.
     - 인스턴스 생성시 black final variable은 값을 입력할 수 있다.
     
```java
public class Foo {
    final int x = 0; // final variable
    final int y; // blank finial variable
    public Foo(int y) {
      this.y = y; // blank final variable initialization
  }
}
```