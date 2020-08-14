# 제네릭 (Generic)

- 대상 객체의 타입을 입력받아서 사용하는 형식
    - 미리 사용할 수 있는 타입을 명시해서 컴파일 타임에 체크 가능
    
- 입력을 Object로 하면 할 수 도 있으나, 런타임에 instanceof로 객체를 체크해야 함
    - 내가 원하는 객체가 들어왔나 확인 화는 과정을 거쳐야 한다.
    - 하지만 제네릭을 사용할 경우 이러한 과정 없이 간결하게 코드 작성을 할 수 있다.


## 재네릭 클래스 생성
```java
// 일반 클래스
class Foo{

}
//재너릭 클래스
// 클래스를 선언할때에는 설정되지 않은 타입이 있으며, 이것을 타입 파라미터로 표현한다
class GenericFoo<T> { // T: 타입 파라미터
    String name;
    T memberVar;

    public GenericFoo(String name, T memberVar) { // 어떤타입이 들어올지 모름
        this.name = name;
        this.memberVar = memberVar;
    } // 생성자에는 <T> 생략

    //T를 자료형 처럼 멤버변수와 메소드에 사용할 수 있음

interface GenericInterface<T>{ //인터페이스도 제네릭이 가능

}
class HashMap<K,V>{ // 여러개의 타입 파라미터도 쓸 수 있다.

}
public class Generics {
    public static void main(String[] args) {
        GenericFoo<String> foo = new GenericFoo<String>("name","var");
        // 클래스명에 <>을 붙여서 자료형을 넣어준다. T => String으로 쓰겠다

        GenericFoo<String> foo1 = new GenericFoo<>("name","var");
        // 뒤에 클래스명에 <>는 자료형이 생략가능하다, 위에도 회색으로 뜨자나

        System.out.println(foo.name);// name
        System.out.println(foo.memberVar);// var
}
}
}
```
- 제너릭 클래스는 클래스명 뒤에 <>을 붙여 안에 타입파라미터를 넣어준다 ex)class GenericFoo<T> {}
    - 타입 파라미터는 클래스 선언시 아직 결정되지 않은 타입이다
        - 타입 파라미터는 참조형 타입만 올 수 있다 - 기본형(primitive)타입은 안됨
    - 그 후 클래스안에서 T를 자료형으로 선언할 수 있다.
    - 생성자에는 T를 생략한다
    

- 인터페이스도 제너릭으로 생성할 수 있다

- 타입 파라미터의 갯수는 여러개가 될 수 있다.

- 타입 파라미터 T는 객체 생성시 클래스명 뒤에 <>을 붙여 입력해 준다 
    - ex)GenericFoo<String> foo = new GenericFoo<String>("name","var");
    - 첫 클래스명에만 <자료형>을 써주고 뒤에 <>는 생략이 가능하다
    

## 제너릭 클래스의 사용 제한

```java

class GenericBar<T>{
    // 문법적으로 문제가 있는경우
    // static T classVar; // not possible
    // 객체 생성시 자료형을 넣는데 객체를 생성안하고 사용하는 static에 사용 불가

//    static void method(T var){
//        return var;
//    } // not possible too or two

    // 스태틱 메서드도 마찬가지로 클래스에 속해 있기 때문에 당연히 안됨.

    // 문법적으로 문제가 없을 것 같으나, 안정성 문제로 금지

    // T memberVar = new T(); not possible

//    {
//        Object obj = new Object();
//        if(obj instanceof T){ // not possible
//
//        }
//    }
   
}
```
- 문법적으로 문제가 있는경우

    - 정적 변수의 자료형으로 타입파라미터를 사용할 수 없다 ex) static T classVar; // not possible
        - 객체 생성시 자료형이 정해지기 때문에 
        
    - 스태틱 메서드의 파라미터의 자료형도 타입파라미터를 사용할 수 없다 ex) static void method(T var){}
        - 스테틱 메서드는 사용할 수 있지만 자료형으로 타입파라미터를 활용할수 없다

- 문법적으로는 문제가 없지만 안정성 문제로 제한이 되는 경우

    - 안정성 문제 : 타입 파라미터가 어떤 것으로 구현되 있을지 모르는 상황에서 안정성에 문제가 생길 수 있는 상황
        - 자바에서는 이런식으로 구현하지 말라고 막혀있음
        
    - 타입파라미터 형으로 객체를 생성할 수는 없다.
        - ex) T memberVar = new T();// not possible
        
    - instacneof의 비교 대상이 될 수 없다
        - ex) Object obj = new Object(); if(obj instanceof T) not possible
        

## 제네릭 타입의 상속

```java
class GFoo<T> {

}

interface IGFoo<T>{

}



class GIGFoo<K, T, D> extends GFoo<T> implements IGFoo<D>{
    //GIGFOO 도 제너릭 클래스이고 제너릭클래스를 상속하는데 뒤에 제너릭 클래스와 제너릭 인터페이스를 상속하는것
    // 그럼 제너릭 클래스가 아니면?

}

// 부모 클래스/ 인터페이스들에 동일한 타입 파라미터를 넘겨줄 수 있다.
class IGIFooTwo<T> extends GFoo<T> implements IGFoo<T>{

}
```
- 제너릭 클래스와 인터페이스 모두 상속과 구현이 가능하다

    - 상속받은 클래스는 제너릭 클래스가 되고 각각 상속이나 구현하는 타입 파라미터를 표시해준다
        - 타입 파라미터를 표시할 때는 각각의 파라미터를 독립적인 타입 파라미터로 할 수 있다
            -ex) class GIGFoo<K, T, D> extends GFoo<T> implements IGFoo<D>
            
        - 각각의 파라미터를 하나의 타입 파라미터로 통합 시킬 수 도 있다
            - ex) class IGIFooTwo<T> extends GFoo<T> implements IGFoo<T>
            
    - 부모 클래스와 인터페이스 명에도 타입 파라미터를 표시해주어야 한다
    
    - 자식 클래스에서 타입 파라미터를 추가할 수도 있다.
    
## 제너릭 타입 제한
```java
// 타입 제한을 하지 않으면 extends Object와 동일하다 // 묵시적으로 extends Object
class GenericNoTypeLimit<T extends Object>{}

// extneds를 이용해서 부모 클래스와 인터페이스도 제한할 수 있다.
class GenericTypeLimitation<T extends Number >{//Number는 추상클래스를 상속하고 있는애들만 사용할 수 있음
                                                          //요 추상클래스도 상속하고 있으며 요인터페이스도 구현해야한다
class GenericTypeLimitation<T extends Number & Cloneable >{
    GenericTypeLimitation<Number> genericTypeLimitation = new GenericTypeLimitation<>();
}
}
```
- 제너릭 클래스의 타입 파라미터 뒤에 extends를 하여 타입 파라미터에 올 수 있는 타입을 제한할 수 있다.
    - 생략시 extedns Object를 하는 것과 동일하다 (Object 는 모든 클래스의 부모 클래스이기 때문)
    
    - 클래스명 작성시 해당 클래스를 상속하고 있는 클래스만 타입으로 입력할 수 있다(본인포함)
        - ex) class GenericTypeLimitation<T extends Number >
        - GenericTypeLimitation<Number> genericTypeLimitation = new GenericTypeLimitation<>();
        
    - 타입을 제한할 클래스와 인터페이스를 동시에 사용할 수 있다 
        - &를 통해서 앞에 클래스를 쓰고 뒤에 인터페이스를 사용한다
        - 앞에 클래스를 상속하고 뒤에 인터페이스를 구현한 클래스로 제한한다는 뜻이다.
        - 클래스와 인터페이스는 독립적인 요소로 아무클래스나 해당 인터페이스를 구현하여 사용할 수 있다.
            - ex) class GenericTypeLimitation<T extends Number & Cloneable >{}
                - Number을 상속하고 Coneable을 구현한 클래스로 제한한다
        
        
## 제너릭 메소드
```java
class GenericMethod{
    public static <T> T staticMethod(T t){
        return t;
    }
  

    public int method(int x){
        return x;
    }

    public <T> T method(T x){
        return x;
    }
    

public class Generics {
    public static void main(String[] args) {
        
        GenericMethod.staticMethod(new String("abcd")); // 오버로딩된것처럼 해당 값들어오면 자료형이 결정됨
        GenericMethod.staticMethod(12341); // new 안해도되고 입력만 하면 자동으로 타입을 설정함
        // 이때는 묵시적이라 int입력이 가능했데..무슨말일까 => 설명해주신데

}
}
}
```
- 제너릭 메서드는 클래스에 타입파라미터를 사용한 것이 아닌 메서드에 타입파라미터를 선언한 것이다
    - 접근제어자 뒤에 타입파라미터 작성해서 반환과 파라미터 다 활용할 수 있다.
    - ex) public <T> T method(T x){ return x; }
    
- 제너릭 메서드의 타입파라미터는 클래스 타입파라미터와 별개이다
    - 제너릭 클래스와는 다르게 제너릭 메서드에서는 타입 파라미터를 자료형으로 선언할 수 있다
    - 이는 제너릭 클래스와는 다르게 타입 파라미터를 메서드 자체에서 입력할 수 있기 때문이다
         - ex) public static <T> T staticMethod(T t){ return t;}
         
- 제네릭 메소드는 타입파라미터 자료형을 따로적지 않고 오버로딩 된 것 처럼 Arguments에 입력하면 자동으로 해당 자료형을 설정한다
    -"abcd"로 입력하면 String이 되고 12341입력하면 INTEGER로 인식함
    
- 제너릭 메서드는 자료형이 정해져있지 않기 때문에 런타임때 정의 되어 지는 동적바인딩을 사용한다
   
    - 우리가 실행을 누루면 코드로 작성한 자바파일을 바이트코드로 변환하는 컴파일일과
    - 컴파일된 파일을 실제 동작하게 하는 런타임으로 구분된다
    - 일반적인 경우 컴파일시 메소드가 정의가 되는 정적바인딩을 사용한다
    

## 와일드 카드

```java
class WildFoo{

}

class WildBar extends WildFoo{

}

class WildGeneric<T>{

}


class WildCard{
    public void method1(WildGeneric<?> x){}// WildGeneric<String> x 명시할수도 있음
                                            // ? 을 통해 아무 타입이나 들어올수 있게해줌
    public void method1_eq(WildGeneric<? extends Object> x){} // Object가 상한 -> 모든 클래스 사용가능
    // objext를 조상으로 두고있는애 즉 모든 클래스를 사용할 수 있다.
    public void method2(WildGeneric<? extends WildFoo>  x){} // 그것을 제한하는 방법 // WildFoo, WildBar
    // WildFoo를 조상으로 두고 있는애 , WildFoo를 포함한다
    public void method3(WildGeneric<? super WildBar>  x){} // Object, WildFoo,  WildBar
    // Super는 반대 WildBar를 자식으로하는 이상의것들
    public void method4(WildGeneric<String> x){}

 
public class Generics {
    public static void main(String[] args) {

        WildCard wildCard = new WildCard();
        WildGeneric<String> wildGeneric4 = new WildGeneric<String>();
        wildCard.method4(wildGeneric); 
        

}
}
}
```

- 와일드카드란, 제네릭 클래스의 객체를 메소드의 매개변수로 받을 때, 그 객체의 타입 변수를 제한하는 것을 말한다
    - 입력받을 재네릭 클래스의 객체의 타입을 제한하는 것을 뜻함
    - public void method1(WildGeneric<String> x){} 

- 와이드카드는 입력받을 클래스명뒤에 타입파라미터 자리에 ? 입력하여 표현할수 있음
     - <?>는 <? extends Object>와 같은 뜻임 = 모든 클래스를 타입파라미터로 할 수 있음
    
    - <? extends "class"> 타입파라미터를 class를 조상으로 두고 있는 클래스를 뜻함 (본인 포함)
        - <? extends WildFoo> 는 WildFoo를 조상으로 두고있는 클래스를 뜻함 (WildFoo 포함)
            - WildFoo, WildBar
 
    - <? super "class"> 타입파라미터를 class를 조상으로 두고 있는 클래스를 뜻함 (본인포함)
        - <? super WildBar>는 반대로 WildBAR를 자식으로 하는 이상의 것들을 뜻함 (WildBar 포함)
            - WldBar, WildFoo, Object
            
            
### 정리

- 제네릭의 문법은 많지만 이해보다는 제네릭으로 이루어진것을 사용하는 방법을 아는데 중점을 두어야한다


