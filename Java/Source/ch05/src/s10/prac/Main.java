package s10.prac;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//
//        }
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//
//        }
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//
//        }
//
//        System.out.println(list);
//
//        Set<Integer> set = new HashSet<>(list);
//
//        System.out.println(set);
//
//        class Foo{
//            int x,y;
//
//            public Foo(int x, int y) {
//                this.x = x;
//                this.y = y;
//            }
//
//            @Override
//            public String toString() {
//                return x + ", " + y;
//            }
//        }
//
//        NavigableSet<Foo> treeSet = new TreeSet<>((Comparator.comparingInt(o -> o.x)));
//        treeSet.add(new Foo(1, 100));
//        treeSet.add(new Foo(4, 50));
//        treeSet.add(new Foo(0, 170));
//        treeSet.add(new Foo(-2, 3300));
//        treeSet.add(new Foo(3, 574));
//
//        System.out.println(treeSet.first());
//        System.out.println(treeSet.last());
//        System.out.println(treeSet.lower(new Foo(1, 500))); // 1보다 작으니 0이 출력됬구나
//        System.out.println(treeSet.floor(new Foo(1, 500))); // 1, 100
//        System.out.println(treeSet.higher(new Foo(1, 500))); // 다음게나온거네
//        System.out.println(treeSet.ceiling(new Foo(2, 500))); // 1, 100 같으네있으면 그걸반환하고 아니면 다음객채
//
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//        System.out.println(treeSet.pollFirst());
//
//
//        Map<String, Integer> map = new HashMap<>();
//
//        System.out.println(map.put("abc",123));
//        System.out.println(map.put("abc",456));
//
//        System.out.println(map.get("abc"));
//
//        System.out.println(map.getOrDefault("def",0));
//
//        System.out.println(map.put("def", map.getOrDefault("def",123)));
//        System.out.println(map.get("def"));
//
//        for(String key: map.keySet()){
//            System.out.println(key +","+map.get(key));
//        }
//
//        for(Map.Entry<String, Integer> entry: map.entrySet()){
//            System.out.println(entry.getKey() + "," + entry.getValue());
//        }
//
//        NavigableMap<String, Integer> map2 = new TreeMap<>();
//        map2.put("a",13);
//        map2.put("b",30);
//        map2.put("c",70);
//        map2.put("d",84);
//        map2.put("e",90);
//        map2.put("f",21);
//        map2.put("a",91);
//        map2.put("c",43);
//
//        System.out.println(map2);
//
//        System.out.println(map2.ceilingKey("d"));
//        System.out.println(map2.ceilingEntry("d").getValue());
//        System.out.println(map2.pollFirstEntry().getValue());
//        System.out.println(map2.pollFirstEntry().getValue());
//        System.out.println(map2.pollFirstEntry().getValue());


        List<String> list = new ArrayList<>();

        list.add("안녕");
        list.add("하세요");
        list.add("슈가에");
        list.add("아유미");
        list.add("에요");

        Set<String> set = new HashSet<>(list);
        set.add("아니");
        set.add("누구");
        set.add("세요");

//        System.out.println(set.containsAll(list));
//        System.out.println(set);

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }

        for (String string : list) {
            System.out.println(string);
        }

    }

}
