package s10.prac;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);

        }
        for (int i = 0; i < 10; i++) {
            list.add(i);

        }
        for (int i = 0; i < 10; i++) {
            list.add(i);

        }

        System.out.println(list);

        Set<Integer> set = new HashSet<>(list);

        System.out.println(set);

        class Foo{
            int x,y;

            public Foo(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return x + ", " + y;
            }
        }

        NavigableSet<Foo> treeSet = new TreeSet<>((Comparator.comparingInt(o -> o.x)));
        treeSet.add(new Foo(1, 100));
        treeSet.add(new Foo(4, 50));
        treeSet.add(new Foo(0, 170));
        treeSet.add(new Foo(-2, 3300));

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower(new Foo(1, 500)));


    }

}
