package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        class Customer{

            private int num;
            private String name;
            private int age;
            private int cost;

            public Customer(int num, String name, int age, int cost) {
                this.num = num;
                this.name = name;
                this.age = age;
                this.cost = cost;
            }

            public int getNum() {
                return num;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public int getCost() {
                return cost;
            }

            @Override
           public String toString(){
                return name +","+age+","+cost;
            }
        }

        Customer[] customers = {new Customer(1, "이순신",40 , 100),
                                 new Customer(2, "김유신", 20, 100),
                                 new Customer(3, "홍길동", 13, 50)};

        List<Customer> list = Arrays.asList(customers);
        System.out.println(list);

        System.out.println("#1 고객명단");
        Stream<Customer> stream = list.stream();
        stream.map(s -> s.getName())
                .forEach(System.out::println);

        System.out.println("#2 여행의 총비용");
        stream = list.stream();
        System.out.println(stream.map(s -> s.getCost()).reduce(0, (val1, val2)-> val1+val2));
        stream = list.stream();
        System.out.println(stream.mapToInt(s -> s.getCost()).sum());

        System.out.println("#2 고객 중 20세 이상인 사람을 이름으로(가나다순)정렬하여 출력합니다.");
        stream = list.stream();
        stream.filter(s -> s.getAge()>=20)
                .sorted((o1,o2)-> o1.getName().compareTo(o2.getName()))
                .map(Customer::getName)
                .forEach(System.out::println);


    }
}
