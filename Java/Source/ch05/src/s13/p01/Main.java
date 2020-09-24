package s13.p01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // JAVA7
        List<String> list =  Arrays.asList("fast", "campus", "rocks");
        List<String> newList = new ArrayList<>();

        for(String s : list){
            newList.add(s.toUpperCase());//대문자로 변환해서 add
        }

        for(String s: newList){
            System.out.println(s);
        }
        //FAST
        //CAMPUS
        //ROCKS
        System.out.println("");


        // JAVA8 - STREAM API -> 훨씬 더 간결한 코드로 작성할 수 있다
        List<String> list1 = Arrays.asList("fast", "campus", "rocks");
        Stream<String> stream = list1.stream(); // stram으로 변환해주는것
        stream.map(String::toUpperCase)
                .forEach(System.out::println);
        //FAST
        //CAMPUS
        //ROCKS
        // 스트림으로 변환만 해주면 Upercase로 바꾸고 출력한다라는 기능을 아주 쉽게 구현할 수 있다
        // 길게쓰는 코드는 쭉이어서 작성할수 있지만 람다식은 시처럼 고민해서 쓰는것이래..오

        // 스트림 생성 방식1.
        Stream<String> stream1 = list1.stream();// 제네릭 T를 가진 기본형 stream// 객체를 대입

        // 스트링 생성 방식2.
        int[] ints = {4, 6, 2, 19, 2, 58, 4, 6, 5};
        // Arrays 클래스의 클래스 메소드 stream을 이용한것 // array는 객체가 아니기 때문에...?
        IntStream insStream = Arrays.stream(ints);
        // LongStream, DoubleStream 도 있다. // P type같네
        // Wrapper클래스 사용안하고 PType쓰는건 오토박싱 언박싱 없이 효율적으로 사용가능

        // 스트림 생성 방식3.
        // Stream 클래스의 메서드 of // 가장 직접적인 생성 방식이래
        // DoubleStream doubleStream = DoubleStream.of(0.4, 0.6, 0.2, 1.2, 0.94);

        // range를 이용한 스트림
        // 정수를 시작부터 끝까지 쭉 뱉어주는 친구 => fori문을 대체하는 스트림
        IntStream intStream1 = IntStream.range(0,10);// => 10은 포함되지 않는다
        intStream1.forEach(System.out::println);
        // 0 1 2 3 4 5 6 7 8 9
        IntStream intStream2 = IntStream.rangeClosed(0,10);// => 10은 포함되지 않는다
        intStream2.forEach(System.out::println);
        // 0 1 2 3 4 5 6 7 8 9
        //LongStream도 range, rageClosed가 있다
        System.out.println("");

        // Random 객체를 이용한 스트림
        Random random = new Random();
        // 메서드목록보면 유용한게많다
//        LongStream longStream = random.longs(); // 개수 제한 없이 무한히 출력한다
//        longStream.forEach(System.out::println);

        // 개수 제한 가능
//        LongStream longStream1 = random.longs(100); // 개수를 정할 수 있다
//        longStream1.forEach(System.out::println);

        // 개수 제한 + 범위 제한 가능 => 가장 많이 사용하는 기능
        LongStream longStream2 = random.longs(100,0,1000 );
        longStream2.forEach(System.out::println);


        // 중간처리 메소드 - 새로운 스트림을 반환한다
        System.out.println("");
        Stream<String> stringStream = Stream.of("Java","Is","Fun","Isn't","It","?", "Java");

            //필터링 메소드
        //distinct() 스트림에 같은 요소가 있을 경우 하나만 남기고 삭제하는 메소드
        stringStream.distinct().forEach(System.out::println);
        //stringStream.distinct() -> 이것자체도 스트림이된다
        System.out.println("");

        //filter(): Predicate 계열을 입력으로 받아서, true인 요소만 남긴다 (조건문의 true인요소() -> true만 필터한다
        stringStream = Stream.of("Java","Is","Fun","Isn't","It","?");
        stringStream.filter(s -> s.length() >= 3).forEach(System.out::println);
        System.out.println("");

            //자르기 메소드(Cutting)
        // skip(long n): 스트림의 최초 n개 요소를 생략하는 메소드
        // limit(long maxSize): 스트림의 최대 요소 개수를 maxSize로 제한
            // 미치지 못하면 그냥 그대로 가지고가고 넘으면 순서대로해서 뒤에가 짤림

            //정렬 (Sorting)
        //Comparable 인터페이스의 compareTo 메소드 정렬(기본 정렬 방식)
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted().forEach(System.out::println);
        System.out.println("");

        //Comparator 인터페이스를 람다식으로 구현하여 정렬
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);
        System.out.println("");

            // 매핑(Mapping) -> 입력요소 1 : 1 출력요소
        // Function 계열의 인터페이스를 사용하여 스트림의 각 요소를 매핑 => 안에있는애들을 다 매핑해버림
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        // Function 계열로 String -> Integer로 변환하는 매핑
            // -> 문자열로 이루어진 stream을 다른 stream으로 변환
        Stream<Integer> stream2 = stringStream.map(s -> s.length()); // Integer stream으로 받아줘야함
        //Function<String, Integer> 느낌으로 된것
        stream2.forEach(System.out::println);
        System.out.println("");


        //PStream (기본형 타입의 스트림)dms Operator 계열로 처리한다(자료형 변환 x)
        IntStream intStream3 = IntStream.of(5,2,30,8,0,2,-34);
        IntStream intStream4 = intStream3.map(value -> value * 10);
        intStream4.forEach(System.out::println);
        System.out.println("");

          // flatMap 계열 매핑 -> 입력 1 : n 출력 (스트림 형태로 출력)
        List<String> list2 = Arrays.asList("java", "backend", "best", "course");
        list2.stream().flatMap(s -> {
            return Arrays.stream(s.split(""));
            // s,split : "java" -> {"j", "a", "v", "a"}
        }).forEach(System.out::println);
        System.out.println("");


            //조회(Peek) - 중간 결과를 출력해볼 수 있음 (디버깅 가능)
        // peek() -> Consumer 계열을 람다식 입력으로 받아 입력 요소를 소비
        list2.stream().flatMap(s -> {
            return Arrays.stream(s.split(""));
            // s,split : "java" -> {"j", "a", "v", "a"}
        }).peek(s -> System.out.println("flatMap(): " +s))
                .distinct().peek(s -> System.out.println(("distinct(): "+ s)))
        .count();
        // 요소가 하나씩 계산이된다
        // => 하나씩 쭉되는게아니고 flatNam() 다음에 distinct() 하나씩 출력해준다다
            //최종 처리 메소드가 있어야만 중간 메소드가 작동을 한다
        System.out.println("");

        // 최종처리 메소드 - 스트림의 끝 -> 스트림을 반환하지 않음(
            // (void일 수도 있고, 무언가 리턴 할 수 도 있다)

            //매칭 계열 - boolean 타입의 값을 리턴
        // allMatch(), anyMatch(), nonMatch()
        // Predicate 계열 람다식을 입력받아,
            // allMatch((Predicate<T> predicate)) : 모든 요소가 true일 경우 true를 리턴
            // anyMatch((Predicate<T> predicate)) : 하나라도 요소가 true일 경우 true 리턴
            // noneMatch((Predicate<T> predicate)) : 모든 요소가 false이면 true 리턴

        Stream<String> st0 = Stream.of("abc", "cde","efg");
        System.out.println(st0.allMatch(s -> s.equals("abc")));

        st0 = Stream.of("abc", "cde","efg");
        System.out.println(st0.anyMatch(s -> s.equals("abc")));

        st0 = Stream.of("abc", "cde","efg");
        System.out.println(st0.noneMatch(s -> s.equals("abc")));

            // 집계 (통계)
        // 기본형 스트림 (Int, Long, Double) - count(), sum(), average(), min(), max()
        // Strema<T>타입 스트림 - count(), min(), max() -> (min과 max는 Compartor 구현 필요 -> 객체 비교기 때문)

        // reduce() 메소드 -> 사용자 정의 집계 메소드
        System.out.println(IntStream.range(0, 10).reduce(0,(value1, value2) -> value1 + value2)); //sum());
        // 처음부터 누적해서 연산을 해나가는 것. 어큐멀레이션
        // identity -> 맨처음 누적값과 첫번째값을 연산하기 위함
        // 0+0, 0+1, 1+2, 3+3 ....
        // sum() 이 reduce를 이용해서 구현이 되어 있다다

//        System.out.println(IntStream.range(0, 10).reduce(Integer.MAX_VALUE, (value1,value2) -> value1 < value2));
        //- > 구현해야함

            //반복 - 소비
        //forEach() -> Consumer 계열의 람다식 입력받아, 각 요소를 소비(하는 것으로 끝남)
        //forEach()는 void 출력
        //예는 위에서 찾아봐


            // 수집 - Colletion으로 반환하는 collet() 메소드
        //Stream API는 JCF -> Stream -> 처리 -> 결과(출력, 값, Colletion)





















    }
}
