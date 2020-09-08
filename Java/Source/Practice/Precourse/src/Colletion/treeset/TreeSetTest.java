package Colletion.treeset;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<String>();

        treeSet.add("홍길동");
        treeSet.add("강감찬");
        treeSet.add("이순신");

        for(String str : treeSet){
            System.out.println(str);  // 강감찬 이순신 홍길동// 오름찬순되어있음
                                    //String에 이미 Comparable 구현되어잇음
        }
    }

}
