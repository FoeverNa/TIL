# 람다식 (Lambda Expression)

## 람다식이란

- Java 1.8에서 추가된 함수형 프로그래밍 기법

- 객체지향 프로그래밍과 다르게, 비즈니스 로직만을 빠르게 구현하는 특징

  - 비지니스 로직 - Mission Critical한 부분 (둘이 비슷한 표현) <=  돈이 되는 부분을 얘기함()
    - 프로그래밍을 해서 돈이 안벌린다면 구지 프로그래밍을 할 이유가 없는것 (미사여구 빼고)
    - 프로그램을 작성하고 의미가 있으려면 비즈니스 로직을 갖추어야 한다

- 객체지향 언어인 Java에서 메소드를 함수처럼 사용하는 형식

  - Java에는 원래 함수라는 것이 없다..

  - 근데 함수형 프로그래밍을 하려면 '1급 함수'라는 개념이 필요하다

    - 1급 함수 

  - 이것이 가능하게 하는 것이 람다식 이다

  - 어떻게 가능하게 하나?

    - 클래스 with 메서드(한개) = 함수로 가장

    

## 람다식의 예

### 배열의 정렬

- 기본 정렬 방식을 이용한 정렬

  ```java
  String [] strings = {"fast", "campus", "java", "backend", "school"};
  System.out.println(Arrays.toString(strings));
  Arrays.sort(strings);
  System.out.println(Arrays.toString(strings));
  ```

  ```java
  public int compare(String o1, String o2) {
      return o1.compareTo(o2);
  }
  ```

- 익명 내부 클래스를 이용한 정렬 방식 변경

  ```java
  Arrays.sort(strings, new Comparator<String>() { // 객체를 생성하여 전달
      @Override
      public int compare(String o1, String o2) {
          return o1.compareTo(o2) * -1; // 내림차순
      }
  });
  ```

- 람다식을 이용한 정렬 방식의 변경

  ```java
  Arrays.sort(strings, (o1, o2) -> {return o1.compareTo(o2) * -1;});
  ```

  ```java
  Comparator<String> comp = (o1, o2) -> {
      return o1.compareTo(o2) * -1;
  };
  Arrays.sort(strings, comp);
  ```

- 함수형 인터페이스 (Functional Interface)

  - 추상 메소드가 단 하나 존재하는지 검사

    ```java
    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
        ...
    }
    ```

## 람다식의 형식

```java
(String x) -> { System.out.println(x); }

(x) -> { System.out.println(x); }

x -> System.out.println(x)

() -> System.out.println("x");  // () 생략 불가능

(x) -> {
    System.out.println(x);
    return x;
}

(x) -> "x: " + x

// x -> "x :" + x               // () 생략 불가능
```

## 람다식의 변수 참조

- 익명 내부 클래스와 동일한 규칙으로 변수 참조

- 문법적으로 this의 사용법만 다름

  - 익명의 내부 클래스와 달리 외부 클래스를 참조

  ```java
  @FunctionalInterface
  interface FunctionalInterface {
      String method();
  }
  
  class Main {
      void functionalMethod(FunctionalInterface obj) {
          System.out.println(obj.method());
      }
  
      public static void main(String[] args) {
          functionalMethod(()-> {
              System.out.println("this: " + this);
              System.out.println("OuterClass.this: " + Main.this);
              return "Lambda expression used."
          });
  
          functionalMethod(new FunctionalInterface() {
              @Override
              String method() {
                  System.out.println("this: " + this);
                  System.out.println("OuterClass.this: " + Main.this);
                  return "Anonymous inner class used."
              });
      }
  
  }
  ```





## 표준 함수형 인터페이스

- 자주 사용되는 함수형 인터페이스를 정의해 둔 API
  - 람다식은 정형화 될 수 밖에 없고 그것을 표준형으로 만들어 놓음 => 활용하면 편리하다
  - 사용자정의 함수형 인터페이스다는 표준 함수형 인터페이스를 이용하는 것이 편리하다
- 람다식을 이용한 함수형 인터페이스를 어떻게 사용할 것인가에 관한 내용
  - 하나의 추상메서드와 디폴드메서드를 어떻게 연계해서 사용할 것인가를 이해해야 한다
  - 여러 표준 함수형 인터페이스를 연계해서 사용하는 경우를 이해해야한다=> 이것을 위해 표준 함수형 사용한다
- Consumer, Supplier, Function, Operation, Predicate 계열이 있다.

| 계열      | 입력 | 출력      | 메소드                          | 설명                                       |
| --------- | ---- | --------- | ------------------------------- | ------------------------------------------ |
| Consumer  | O    | X         | `void accept(T)`                | 입력을 소비 // 입력만 받고 출력은 하지않음 |
| Supplier  | X    | O         | `T get()`                       | 출력을 공급  // 입력받지 않고 출력만 한다  |
| Function  | O    | O         | `R apply(T)`//입력 출력타입변환 | 입력 -> 출력 함수 매핑                     |
| Operation | O    | O         | `T apply(T)`                    | 입력을 연산하여 동일 타입의 출력으로 리턴  |
| Predicate | O    | `boolean` | `boolean test(T)`               | 입력을 판단//참인지 거짓인지 판단          |

### 표준 함수형 인터페이스의 종류

인터페이스이기 때문에 입력파라미터, 출력값만 달라질수 있다.

#### Consumer 계열

| 인터페이스             | 메소드                                                       |
| ---------------------- | ------------------------------------------------------------ |
| `Consumer<T>`          | `void accept(T t)`//입력값으로 출력이아닌 다른방식으로 영향을 주는 역할 |
| `BiConsumer<T, U>`     | `void accept(T t, U u)`                                      |
| `IntConsumer`          | `void accept(int value)`                                     |
| `LongConsumer`         | `void accept(long value)`                                    |
| `DoubleConsumer`       | `void accept(double value)`                                  |
| `ObjIntConsumer<T>`    | `void accept(T t, int value)`                                |
| `ObjLongConsumer<T>`   | `void accept(T t, long value)`                               |
| `ObjDoubleConsumer<T>` | `void accept(T t, double value)`                             |

#### Supplier 계열

| 인터페이스        | 메소드                   |
| ----------------- | ------------------------ |
| `Supplier<T>`     | `T get()`                |
| `BooleanSupplier` | `boolean getAsBoolean()` |
| `IntSupplier`     | `int getAsInt()`         |
| `LongSupplier`    | `long getAsLong()`       |
| `DoubleSupplier`  | `double getAsDouble()`   |

#### Function 계열



| 인터페이스            | 메소드                                                       |
| --------------------- | ------------------------------------------------------------ |
| `Function<T, R>`      | `R apply(T t)` T라는 입력 타입 받아서 R이라는 입력타입으로 매핑해주는 것 |
| `BiConsumer<T, U, R>` | `R apply(T t, U u)`                                          |
| `PFunction<R>`        | `R apply(p value)`                                           |
| `PtoQFunction`        | `q applyAsQ(p value)`                                        |
| `ToPFunction<T>`      | `p applyAsP(T t)`                                            |
| `ToPBiFunction<T, U>` | `p applyAsP(T t, U u)`                                       |

```java
P, Q : Int, Long, Double
p, q : int, long, double
```

#### Operator 계열

| 인터페이스             | 메소드                                              |
| ---------------------- | --------------------------------------------------- |
| `UnaryOperator<T>`     | `T apply(T t)`                                      |
| `BinaryOperator<T>`    | `T apply(T t1, T t2)`                               |
| `IntUnaryOperator`     | `int applyAsInt(int value)`                         |
| `LongUnaryOperator`    | `long applyAsLong(long value)`                      |
| `DoubleUnaryOperator`  | `double applyAsDouble(double value)`                |
| `IntBinaryOperator`    | `int applyAsInt(int value1, int value2)`            |
| `LongBinaryOperator`   | `long applyAsLong(long value, long value2)`         |
| `DoubleBinaryOperator` | `double applyAsDouble(double value, double value2)` |

#### Predicate 계열

| 인터페이스          | 메소드                       |
| ------------------- | ---------------------------- |
| `Predicate<T>`      | `boolean test(T t)`          |
| `BiPredicate<T, U>` | `boolean test(T t, U u)`     |
| `IntPredicate`      | `boolean test(int value)`    |
| `LongPredicate`     | `boolean test(long value)`   |
| `DoublePredicate`   | `boolean test(double value)` |

### 표준 함수형 인터페이스의 메소드

#### andThen(), compose()

- 두 개 이상의 함수형 인터페이스를 연결하기 위해 사용 (인터페이스 엮어서 사용하기)

  - `A.andThen(B)`: A를 먼저 실행하고 B를 실행. Consumer, Function, Operator 계열 지원

  ```java
  Function<String, String> funcOne = x -> "str: " + x;
  Function<String, String> funcTwo = x -> "{" + x + "}";
  Function<String, String> andThen = funcOne.andThen(funcTwo); // {str: x}
  ```

  - `A.compose(B)`: B를 먼저 실행하고 A를 실행. Function, Operator 계열 지원

  ```java
  IntUnaryOperator multTwo = x -> x * 2;
  IntUnaryOperator addTen = x -> x + 10;
  IntUnaryOperator multTwo.compose(addTen); // (x + 10) * 2
  ```

#### and(), or(), negate(), isEqual()

- Predicate 계열의 기본 메소드(boolean 계열)

  - and(), or(), negate() (not)
  - 각각 &&, ||, !의 동작을 한다.

  ```java
  DoublePredicate predOne = x -> x > 0.5;
  DoublePredicate predTwo = x -> x < 0.0;
  DoublePredicate predThree = predOne.or(predTwo);
  DoublePredicate predFour = predThree.negate();
  ```

- Predicate 계열의 클래스 메소드

  - isEqual()

  ```java
  Predicate<String> isEqualToString = Predicate.isEqual("String");
  ```

#### minBy(), maxBy()

- BinaryOperator 클래스의 클래스 메소드

  - `Comparator<T>`를 파라미터로 받아 최소값/최대값을 구하는 `BinaryOperator<T>`를 리턴

  ```java
  BinaryOperator<String> minBy = BinaryOperator.minBy((o1, o2) -> {
      return len(o1) > len(o2) ? 1 : -1;
  });
  
  BinaryOperator<Integer> maxBy = BinaryOperator.maxBy((val1, val2) -> {
      return val1.compareTo(val2);
  });
  ```

### 람다식에 메소드/생성자 사용 // 요건 중요하다

- 이미 구현된 메소드가 있는 경우, 다양한 방식으로 람다식을 대체 가능

#### ClassName::instanceMethod

- 첫번째 파라미터를 객체로, 두번째 파라미터를 메소드 입력으로 사용

  ```java
  String[] strings = { "A", "B", "D", "C" };
  Arrays.sort(strings, String::compareTo);// String 클래스에 정의되있는 instanceMethod를 활용한다
  									// 이때 compareTo라는 메서드는 String객체에다가 compareTo(String o)로 정의가 되어 있는애
  
  // 근데 원래 여기에 들어와야 하는애는 Compare(T o1, To2)라는 메서드임, -> 람다식활용하기때문에 객체를사용하지않아서 둘다 입력받음
  
  // 근데 String::comparTo의 경우는 네 => 내일 더 배울거니까 일단 두자
  ```

#### ClassName::classMethod

- 클래스 메소드의 입력으로 모든 파라미터가 사용됨

  ```java
  Function<String, Integer> parser = Integer::parseInt;
  ```

#### instance::instanceMethod

- 주어진 객체의 메소드를 호출

  ```java
  String string = "StringA";
  Predicate<String> pred = string::equals;
  System.out.println(pred.apply("StringA"));
  ```

#### ClassName::new

- 생성자를 이용하여 객체를 생성하는 람다식

  ```java
  IntFunction<String> func = String::new;
  String string = func.apply(10);
  ```

#### ClassName[]::new

- 배열을 생성하는 람다식

  ```java
  IntFunction<String[]> func = String[]::new;
  String [] strings = func.apply(100);
  ```