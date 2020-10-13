package s13.p01.prac;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

//        IntStream intStream = IntStream.range(0, 10);
//
//        System.out.println(intStream.reduce(0,(value1,value2)-> value1 + value2));

//        IntBinaryOperator add = (a,b) -> a+b; // add는 순수함수
//
//        int c = 10;
//
//        IntBinaryOperator add2 = (a,b) -> a+b+c; // add2는 순수함수가 아님
//                                                  // c가 상수라면 add2로 순수함수
//
//        IntBinaryOperator add3 = (a,b) -> {
////            c = b;
//             return a +b;
//        }; // add3는 순수함수가 아님 // but 람다식에서는 c가 상수나 이펙티브상수여야한다고 설정되어있음
//
//
//       class Bar{
//           int val ;
//       }
//       Bar bar = new Bar();
//
//        IntUnaryOperator add4 = b -> bar.val +b; // 외부객체를 변화시키기 때문에 순수함수가 아니다
//
//
//        IntUnaryOperator add5 = b -> {
//            int val = bar.val;
//            return val + b;
//        }; // 외부객체를 변화시키지 않고 값만 참조하기 때문에 순수함수가 맞다
//
//        UnaryOperator<String> op  = (String x) -> x;
//        UnaryOperator<String> op2  = (x) -> x

//        Function<String, Integer> func1 = Integer::parseInt;
//
//
//        UnaryOperator<String> strStream = str.flatMap(s -> s.split(""))
//

//        Stream<String> str = Stream.of("String", "gogogo", "kakao", "quo", "ee");
//

//        IntStream intStream = IntStream.of(2,3,1,2,4,5,1,5,6,6,7,2,,6,6,,98,9,1,2,3,6,8,9,3);
////        IntStream intStream2 = intStream.map(x -> x+12);
//        Stream<String> strStream = intStream.map()
//
//        List<String> list2 = Arrays.asList("java", "backend", "best", "course");
//        list2.stream().flatMap(s -> {
//            return Arrays.stream(s.split("")); // 하나의 String받고 한글자씩 쪼개서 String Stream으로 출력
//            // s,split : "java" -> {"j", "a", "v", "a"}
//        }).peek(s -> System.out.println("one Stream :"+s)).forEach(System.out::println);
//        System.out.println("");

//        String[][] arrays = new String[][]{ {"a1", "a2"}, {"b1", "b2"}, {"c1", "c2", "c3"} };
//
//        Stream<String[]> stream4 = Arrays.stream(arrays);
//
//       stream4.flatMap(s -> Arrays.stream(s)).forEach(System.out::println);

//        String[] s1 = {"yaho","babo"};
//        String[] s2 = {"ani","ichi"};
//
//        Stream<String> stream = Arrays.stream(s1);
//        stream = Arrays.stream(s2);
//
//        stream.forEach(System.out::println);

//        Stream<String> builderStream =
//                Stream.<String>builder()
//                .add("yoho").add("hi").add("안녕")
//                .build();
//
//        builderStream.forEach(System.out::println);

//        Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
//        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
//        Stream<String> concat = Stream.concat(stream1, stream2);
//        concat.forEach(System.out::println);
//
//
//        List<List<String>> list =
//                Arrays.asList(Arrays.asList("a"),
//                        Arrays.asList("b"));
//
//        list.stream().flatMap(s -> s.stream())
//                .forEach(System.out::println);

//        OptionalInt reduced =
//                IntStream.range(1,4)
//                .reduce();
//        System.out.println(reduced);

//        String[] array = {"Collection", "Framework", "is", "so", "cool"};
//        Stream<String> stream = Arrays.stream(array);
//
//        List<String> collected =  stream.collect(Collectors.toList());
//
//        System.out.println(collected);
//        System.out.println(stream.collect(Collectors.toSet()));
//        List<String> liked = stream
//                .filter(s -> {
//                    return s.length() >=3;
//                })
//                .collect(Collectors.toCollection(LinkedList::new));
//        System.out.println(liked);
//
//        Map<String, Integer> mpa =
//                stream.collect(Collectors.toMap( s -> s, String::length));
//
//        System.out.println(mpa);

//        String [] array2 = {"Python", "is", "awful", "lame", "not", "good"};
//        Map<Boolean, List<String>> map = Arrays.stream(array2)
//                .collect(Collectors.partitioningBy(s -> s.length() >3));
//
//        System.out.println(map);
//
//        Map<Integer, List<String>> map2 = Arrays.stream(array2)
//                .collect(Collectors.groupingBy(s -> s.length()));
//        System.out.println(map2);
//
//        Map<Integer, Long> map3 = Arrays.stream(array2)
//                .collect(Collectors.groupingBy(String::length,Collectors.counting()));
//
//        System.out.println(map3);

//        class SharedDelivery{
//            private long deliveryId;
//            private String boxId;
//            private String productId;
//
//            public SharedDelivery(long deliveryId, String boxId, String productId) {
//                this.deliveryId = deliveryId;
//                this.boxId = boxId;
//                this.productId = productId;
//            }
//
//            public long getDeliveryId() {
//                return deliveryId;
//            }
//
//            public String getBoxId() {
//                return boxId;
//            }
//
//            public String getProductId() {
//                return productId;
//            }
//        }
//
//        List<SharedDelivery> sharedDeliveries = Arrays.asList(
//                new SharedDelivery(11, "B001", "Prd-123")
//                ,new SharedDelivery(11, "B001", "Prd-345")
//                ,new SharedDelivery(11, "B002", "Prd-567")
//                ,new SharedDelivery(21, "B003", "Prd-123")
//        );
//
//        Map<Long, Map<String, List<SharedDelivery>>> groupingDeliveries =
//                sharedDeliveries
//                       .stream()
//                        .collect(Collectors.groupingBy(s-> s.getDeliveryId(),
//                                Collectors.groupingBy(s-> s.getBoxId())));
//
//        System.out.println(groupingDeliveries);

//        String [] array2 = {"Python", "is", "awful", "lame", "not", "good"};
//
//        Stream<String> stringStream = Arrays.stream(array2).parallel();
//        System.out.println(stringStream.isParallel());
//        stringStream.map(s -> s.toUpperCase()).sorted().forEach(System.out::println);
//

//        Stream<String> stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
//        stringStream.sorted().forEach(System.out::println);
//        System.out.println("");

//        List<String> list4 = List.of("abcd","efg","hijk","lmnop");
//
//        Stream<String> stream = list4.parallelStream();
////        Stream<String> stream = list4.stream();
//        System.out.println(stream.isParallel());
//        System.out.println("");
//
//        stream.flatMap(s-> Arrays.stream(s.split("")))
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);

//        Integer reducedParallel = Arrays.asList(1,2,3)
//                .parallelStream()
//                .reduce(10,(a,b)-> a+b,(a,b)-> a*b);
//
//        System.out.println(reducedParallel); //60
// 10*1 + 10 *2 + 10 *3 = 60;
// 병렬처리한 값을 마지막에 결합한다

//        Stream stream = Stream.empty();
//
//        Stream<String> generatedStream = Stream.<String>builder()
//                .add("Hello")
//                .add("Wrold")
//                .build();
//
//        generatedStream.forEach(System.out::println);
//
//         Stream.generate(() -> "gen")
//                 .limit(5)
//                 .forEach(System.out::println);
//
//         Stream<Integer> itStream = Stream.iterate(30, n -> n +2 ).limit(100);
//
//         itStream.forEach(System.out::println);
//
//        LongStream lStream = LongStream.range(392, 22931223);
//        lStream.forEach(System.out::println);

//        List<String> names = Arrays.asList("Hello", "World", "Test", "array");
//
//        names.stream().filter(s -> s.contains("e"))
//             l;'   .forEach(System.out::println);
//
//        String arr[][] = {
//                {"minus one", "zero", "one"},
//                {"two", "Three"},
//                {"Four", "Five", "Six"},
//                {"eight", "ten"}
//        };
//
//        Stream.of(arr)
//                .flatMap(Stream::of)
//                .forEach(System.out::println);
//w
//
//        Stream.of(arr2)
//                .flatMapToInt(ints -> IntStream.of(ints))
//                .forEach(System.out::println);
//

//        Arrays.asList("Hello", "World", "Test", "array", "Hell")
//                .stream()
//                .skip(2)
//                .forEach(System.out::println);
//

//        Stream<String> streamOne = Arrays.asList("Hello", "World", "Test", "array", "What").stream();
//        Stream<String> streamTwo = Arrays.asList("The", "Hell").stream();
//        Stream.concat(streamOne, streamTwo).forEach(System.out::println);

//        OptionalInt count = IntStream.of(1, 2, 3, 4, 5).min();
//        System.out.println(count);

//        IntStream.of(1, 2, 3, 4, 5)
//                .average()
//                .ifPresent(System.out::println);
//
//

//        String[] array = {"Collection", "Framework", "is", "so", "cool"};
//        Stream<String> stream3 = Arrays.stream(array);
//       String s2 = stream3.filter(s -> s.length() >= 3)
//                .collect(Collectors.joining(","));
//
//        System.out.println(s2);

//
//        class Foo{
//
//        }
//
//        Foo foo = new Foo();
//
//        System.out.println(foo);

        String[] array = {"Java", "Is", "Fun", "Isn't", "It", "?"};
        Map<Character, Long> map = Arrays.stream(array)
                                    .collect(Collectors.groupingBy(s -> s.charAt(0),Collectors.counting()));

        System.out.println(map.getClass().getName() + map);



















    }
}
