package s13.p01.prac;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

//        List<String> list = Arrays.asList("fast", "campus", "rocks");
//        List<String> newList = new ArrayList<>();
//
//        for(String s : list){
//            newList.add(s.toUpperCase());
//        }
//
//        for(String s : newList){
//            System.out.println(s);
//        }
//
//        List<String> list2 = Arrays.asList("fast", "campus", "rocks");
//        Stream<String> stream = list2.stream();
//        stream.map(String::toUpperCase).forEach(System.out::println);
//
//        //스트림 생성방식1
//        Map<String, String> map = new HashMap<>();
//
//        map.put("a", "A");
//        map.put("b", "A");
//        map.put("c", "A");
//        map.put("d", "A");
//
//        Stream<String> stream1 = map.keySet().stream();
//        stream1.forEach(System.out::println);
//
//
//        int[] ints = { 1,2,3,4,5,656,7,8,2,3,4,5,6,7,32,3,2,3,5,2,34,2,465,4,1,23};
//        IntStream intStream = Arrays.stream(ints);
//        intStream.sorted().forEach(System.out::println);
//
//        DoubleStream doubleStream = DoubleStream.of(0.4, 0.6, 0.2, 1.7, 0.94);
//
//        IntStream intStream1 = IntStream.range(5, 19);
//
//        intStream1.forEach(System.out::println);
//
////        intStream1.forEach(System.out::println);
//
//
//        Random random = new Random();
//        LongStream longStream = random.longs(100,0,100);
//        longStream.forEach(System.out::println);
////
//      int[] ints = { 1,2,3,4,5,656,7,8,2,3,4,5,6,7,32,3,2,3,5,2,34,2,465,4,1,23};
//
//        IntStream intStream = Arrays.stream(ints);
//        intStream.filter((i) -> i > 19).forEach(System.out::println);//      int[] ints = { 1,2,3,4,5,656,7,8,2,3,4,5,6,7,32,3,2,3,5,2,34,2,465,4,1,23};

//        int[] ints = { 1,2,3,4,5,656,7,8,2,3,4,5,6,7,32,3,2,3,5,2,34,2,465,4,1,23};
//        IntStream intStream = Arrays.stream(ints);
//        intStream.skip(3).forEach(System.out::println);
//
        //Comparator 인터페이스를 람다식으로 구현하여 정렬
//
//        Stream<String> stringStream = Stream.of("abc","bable", "clock", "wf", "twtie", "dnmov", "work");
//        stringStream.sorted((o1, o2) -> -(o1.compareTo(o2))).forEach(System.out::println);
//        System.out.println("");

//        Stream<String> stringStream = Stream.of("abc","bable", "clock", "wf", "twtie", "dnmov", "work");
//         Stream<Integer> integerStream = stringStream.map(s -> s.length());
//        integerStream.forEach(System.out::println);
//
//        IntStream intStream = IntStream.of(2,3,1,2,4,51,5,1,5,3,6,1,2123,4,12414,453,34,2,4234,234);
//        IntStream intStream1 = intStream.map(v -> v + 10);
//        intStream1.forEach(System.out::println);

//        Stream<String> stringStream = Stream.of("abc","babel", "clock", "wf", "twtie", "dnmov", "work");
//        stringStream.flatMap(s -> Arrays.stream(s.split(""))).forEach(System.out::println);
//
//
//        Stream<String> stringStream = Stream.of("abc","babel", "clock", "wf", "twtie", "dnmov", "work");
//
//        stringStream.flatMap(s -> Arrays.stream(s.split(""))).peek(s-> System.out.println("flatMap(): "+s))
//                .distinct().peek(s -> System.out.println("distinct(): "+ s)).forEach(System.out::println);

//        Stream<String> stringStream = Stream.of("abcd", "ewadfa", "xkcwelkrwo", "wlekjrq");
//        System.out.println(stringStream.allMatch(s -> s.length() < 5));
//        stringStream = Stream.of("abcd", "ewadfa", "xkcwelkrwo", "wlekjrq");
//        System.out.println(stringStream.anyMatch(s -> s.length() < 5));
//        stringStream = Stream.of("abcd", "ewadfa", "xkcwelkrwo", "wlekjrq");
//        System.out.println(stringStream.noneMatch(s -> s.length() < 4));

        IntStream intStream = IntStream.range(0, 10);

        System.out.println(intStream.reduce(0,(value1,value2)-> value1 + value2));

        











    }


}
