# 예외 처리 (Handling Exceptions)

## 오류와 예외

 - 오류(Errors) - 메모리 부족 또는 프로그램 실행이 꼬이는경우
    - 프로그램이 동작 중에 비정상 종료가 발생하는 상황
    - 더 이상 어떻게 프로그램을 복구해야 할 지 알 수 없다.
    - 프로그램의 문제를 해결하여 해결 - 프로그램 종료 후 버그픽스를 해야 한다
        - 오류가 나면 프로그램이 종료되는게 맞고 그걸 계속 무시하고 실행하게 하면 해킹의 위험 발생한다
 
 - 예외 (Exception)
    - 오류에 비해서 심각도가 낮고, 프로그램의 정상적인 흐름만 방해하는 현상
        - 파일을 읽으려 했으나, 해당 파일이 없음 -> 파일만 찾아주면됨
        - 네트워크 연결이 유실 -> 네트워크 리커넥션하면됨
    - 문제 상황을 처리하는 로직을 구현하여, 런타임에서 자연스럽게 해결 가능 하다
     - 사소한 문제들을 유연하게 처리하여 사용자들이 불편함을 느끼지 않고 서비스를 이용할 수 있도로 해주는 기능
        - 특히 서버를 유지하는데 중요한 역할을 한다 
        
      
 - 예외 처리
    - 예외가 발생헀을 경우에, 이 상황을 '감지'하고 '처리'하는 코드
        - try ~ catch, throws, thorw, finally 키워드들을 이용
            - Throwable 클래스를 상속하는 자식 클래스들로 이러한 문제를 해결한다

 - 예외의 종류 2가지
    - Checked Exception
        - Exception 클래스를 상속하고 있으면 Checked Exception 이다
        - 컴파일러에서 에러 발생 - > try ~ catch 를 작성하지 않으면 아예 빌드조차 할 수 없다.(실행도 못함)
        - 무조건 try & catch 를 사용해야 되서 예외 처리를 배우고 나서 사용할 수 있다.
  
     - Unchecked Exception  
       - RuntimeException 클래스를 상속하고 있으면 Unchecked Exception 이다
       - try ~ catch 를 작성하지 않더라도 빌드와 실행이 가능하다
       - 대표적으로 ArrayIndexOutOfBounds, ArithmaticException이 있다
  
                 
## 예외 처리 기법

### try ~ catch 구문

```java
public class Exceptions {
    public static void main(String[] args) {
        // try ~ catch
        try {
            // 예외가 발생할 수 있는 코드 작성
            // 예외가 발생할 경우 예외 객체를 던짐(throw) 어디로?
        } catch (Exception e) { // 던져진 예외를 받음 (catch를 이용해서)
            // Exception 클래스 및 그 자식 클래스를 사용해서 받음(클래스였구나)
            // 에외상황을 처리하는 코드드
        }

//        int[] integers = new int[10]; // 0~9까지 되야되는데 20을넣으면 에러발생
//            integers[20] = 5; // Exception 발생

        try {
            int[] integers = new int[10]; // 0~9까지 되야되는데 20을넣으면 에러발생
            integers[20] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {// 위에서 에러명을 출력해봐서 입력할수 있음
            System.out.println(e.getMessage()); //Index 20 out of bounds for length 10
            // 객체 e에 메세지를 심어준것임. 그걸 message로보여줌
            //에러를 thorw해서 밑에서 catch를 해서 메세지로 출력해준상황
//            e.printStackTrace();// 시뻘건 메세지도 출력해주는애
            // 근데 순서는 맨마지막에 출력됨 // IDE => 버그래, 순서가꼬임
            // 콘솔에서 출려하면 이런에러 안뜬데, 에러자연스럽게 받아들이면됨
        }
//        System.out.println("Programm ended normaly");
        // 에러가 있었음에도 프로그램이 에러가 나지 않고 끝까지 실행되서 출력문까지 출력되고 종료
}
}
```

- try {}안에 예외가 발생할 수 있는 코드를 작성
    - 예외가 발생할 경우 예외 객체를 던진다(throw)
        - 예외가 발생할 경우 코드는 실행되지 않는다??
    - 예외가 발생하지 않을 경우 코드가 실행된다
    
- catch(){} 던져진 예외 객체를 받는 부분
    - ()안에 예외명(클래스명)의 객체를 생성한다
        - {}안에 생성한 객체를 처리하여 해당 예외 일때 수행해야 하는 코드를 적다
            - getMessage()는 해당 에러메세지를 가져오는 메서드
            - printStackTrace()는 오리지널 에러 메세지를 출력해 준다(빨간색 에러메세지)
                - 얘는 어디에 있던 맨마지막에 출력되는 버그가 있음
        
- try~ catch 구문을 통해 예외 처리시 에러가 발생해도 프로그램이 종료되지 않고 끝까지 수행된다
    - 예외처리가 이런 목적을 가지고 수행하는 것이네 생각해보니
    - try ~ catch 구문 바깥에 출력문을 작성해도 실행이 가능하다


### 다중 예외 처리

```java

public class Exceptions {
public static void main(String[] args) {        
//        try {
//            // 아주아주 예민한 내용이 실행되는 부분
//        } catch(ArithmeticException e){// 에러명은 랜덤으로 입력하는 중
//                                        // 첫번째 캐치
//
//        } catch(FileAlreadyExistsException e){ // 첫번째 캐치 후에 두번째 캐치
//
//        } catch(EOFException e){
//
//        } catch(IOException e){
//
//        } catch(Exception e){ // 나머지 모든 Exception을 모두 catch
//                                // 모든 Exception 객체의 조상
//     
//        }
}
}
```
- 여러개의 catch 구문을 사용하면 다중으로 예외처리를 할 수 있다
    - switch~case 문 처럼 첫번째 에러 확인하고 안걸리면 그 다음 예외 확인하는 방식

- 특정 catch 구문에 선택되는 조건은 다형성에 의해 결정된다
    - 즉 catch 하고 있는 구문에 자식 객체면 예외를 catch 할 수 있다
    - 그렇기 때문에 순서도 중요할 수 있다?
    
- Exception 클래스는 모든 예외 클래스에 부모클래스로 사용하면 모든 예외를 모드 catch 할 수 있다
    - 하지만 어떤 에러가 발생하는지 모르고 예외처리를 하는것은 위험한 방식으로 권장하지 않음
        - 항상 어떤 에러가 발생하는지 밝혀진 애들만 예외처리를 해야 한다

### try ~ catch ~ finally 구문

```java
public class Exceptions {
public static void main(String[] args) {     
        try {
            int[] integers = new int[20];
//            integers[21] = 10;
            System.out.println("던졌다?"); //
        } catch (Exception e) {
            System.out.println("받았다!"); // 받았다
        } finally {
            System.out.println("마침내!"); // 마침내!
            // try에서 생성한 리소스를 회수하기 위해

        }

        FileInputStream file = null;
//        file = new FileInputStream(("a.txt"));
//        file.read(); // 두번오류 발생할 수 있음
}
}
```
- try~catch 구문에 finally 구문을 연결한 형태로 어떤 조건하에서도 반드시 실행되어야 하는 구문을 작성하는데 사용한다
    - 예외가 발생하였을 때도 실행되고 예외가 발생하지 않은 상황에서도 실행되는 구문이다
    - try 구문에서 접근한 System 자원을 안전하게 복구하기 위해서 사용된다
        - FileInputStream 같이 파일을 읽어오는 과정에서 에러가 발생할시 close 를 해주어야 할 필요가 있을때 사용한다

### try ~ with ~ resources 구문

```java
public class Exceptions {
    public static void main(String[] args) {
       //예시1
        try {
            file = new FileInputStream(("a.txt"));
            file.read(); // 두번오류 발생할 수 있음 => 어디서 두번 오류발생한다는거지?
        } catch (IOException e) {
            System.out.println("파일 처리 실패");
        } finally {
            if (file != null) {
                try {
                    file.close(); // 이것도 꼭 해줘야하는 이유가 checked exception 있기 때문
                } catch (IOException e) {
                    System.out.println("앗!.. 아아..");
                }

            }

        //예시2            
        try(FileInputStream file1 = new FileInputStream("a.txt")){
            file1.read();
        } catch (IOException e){
            System.out.println("파일처리실패");
        }
            System.out.println("Programm ended normaly");
        }
    }
}
```
- resource 를 회수하기 위해 finally 구문을 사용하는 경우 예시 1 처럼 코드가 길어 질 수 있음
    - 이런 경우 예시2 처럼 try ~ with ~ resource 구문을 사용하여 구문을 짧게 줄일 수 있다
        - Java 1.7에서 추가된 기능으로 AutoClosable 인터페이스를 구현하는 리소스만 사용가능하다(close 메소드를 포함한 인터페이스)

- 아직 FileInputStream이 먼지 모르겟엇어 왜 예외처리하는지도 모르겠음...


## 예외 위임 처리
                                    
```java
// throws 키워드를 이용하여 예외 처리 위임
// methodA의 예외를 methodB로 넘겨서처리함
class checkedExceptionThrow {
    void methodA() throws IOException { 
        FileInputStream file1 = new FileInputStream("a.txt");
        file1.read();
        file1.close();
    }

    void methodB() {//얘도 throws할수도 있고 직접 try catch할수도 있음
        try {
            methodA();
        } catch (IOException e){
            System.out.println("메소드에이실패"); // 처리를 methodB로 위임함
                                                // close()에대한 처리 없음으로 지금 방식은 권장X
        }
    }
}
```
- throws 키워드를 이용하여 직접 예외 처리하는 것이 아닌 위임해서 예외처리를 할 수 있음
    - 메소드의 ()입력 파라미터 옆에 throws 키워드를 사용하고 오류클래스를 명시하여 사용한다
        - 메소드가 throw's' 한다는 동사로 사용된 키워드이다
        
    - 받는 메소드에서 try 구문안에 던진 메소드를 사용하고 catch 구문에서 예외를 핸들링 해준다.'
    
### Unchecked Exception 의 위임 처리

```java
class UncheckedExceptionThrow{
    void methodA(){ // 언첵트익셉션은 throws안해도 알아서 위임됨
        int x= 10/0; //아리스매틱익셉션 // 런타임익셉션
                        //빨간줄이 안뜨는 에러기때문에 어디서 해도상관이없으니 까 안뜨는거래
                        
    }

    void methodB() { // 여기서해도 아래에서 해도 되서 에러가안뜸
        methodA();
    }

    public static void main(String[] args) {
        try{
            new UncheckedExceptionThrow().methodB();
        } catch (ArithmeticException e){
            System.out.println(e.getMessage()); /// by zero
            
        }
    }
}
```

- Unchecked Exception 의 경우에는 throws 키워드를 사용하지 않아도 된다
    - checked Exception 과 달리 컴파일에서 실행까지 되기 때문에 예외처리를 어디에서 하던 상관이 없다
    
- 예외 처리할 곳에서 예외 처리 할 메소드를 사용함
    - catch 에서 에외 클래스와 처리할 방식을 입력해주면 된다

### 메소드를 오버라이드한 경우의 예외 처리
    

```java
class Foo{
    void methodA() throws IOException{}// Checked Exception
}

class BarOne extends Foo{
    void methodA() throws IOException {} // possible
}

class BarTwo extends Foo{
    void methodA() throws FileNotFoundException{}// 더 자식 Exception은 possible
    // FileNOtFoundException은 IOException의 자식 클래스이기 때문에 가능함
}

class BarThree extends Foo{
//    void methodA() throws Exception {}

}

```

- 부모 클래스의 메소드를 오버라이드 할 때, 부모 클래스의 메소드의 예외보다 더 조상인 예외는 던질 수 없다
    - 부모 클래스의 예외가 IOException 이라면 그보다 자식클래스인 FileNotFoundException 은 오버라이드한 자식클래스에서 사용 가능 하다
    - 하지만 IOException 보다 상위클래스 예외인 Exception은 자식클래스의 오버라이드된 메서드에서는 사용 할 수 없다
    
- 이는 오버라이드된 메서드에 일관성을 부여하는 것으로 예외 클래스의 상속관계가 이루어진다면 어느정도 비슷한 기능을 하게 되기 때문이다
    - 이러한 방식은 Java 의 선택적인 구현으로 Java 에 성격을 보여준다