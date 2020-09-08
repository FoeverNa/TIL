package Colletion.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();// set인터페이스를 구현한 hashSet클래스
        set.add("이순신");
        set.add("김유신");
        set.add("유관순");
        set.add("김홍도");
        set.add("강감찬");
        set.add("이순신"); // 중복값은 입력이 안됨

        System.out.println(set); // toString();
                                //[김유신, 강감찬, 이순신, 유관순, 김홍도]// 순서는 순차적이 아님

        Iterator<String> ir = set.iterator(); // Colletino 인터페이스 구현한 클래스는 다숑ㅇ가능


        while(ir.hasNext()){ // hsNext는 다음 자료가 있는지 체크
           String str = ir.next();// next는 다음자료를 담는역할
            System.out.println(str);
        }

    }
}
