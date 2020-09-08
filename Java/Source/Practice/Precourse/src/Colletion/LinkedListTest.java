package Colletion;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<String>();

        myList.add("A"); //add() 공통적으로 자료를 입력하는 메서드
        myList.add("B");
        myList.add("c");

        System.out.println(myList); // toString()메서드, 요소를 보여주는역할

        myList.add(1,"D"); //index를 지정하여 입력
        System.out.println(myList);
        myList.removeLast();// 마지막 자료를 지우는 메서드(First도있음)
        System.out.println(myList);

        for(int i =0; i<myList.size(); i++){ //List들은 이렇게 index를 통해 접근가능//순서에 따라 저장하기 때문에
            String s = myList.get(i);       //나중에 배울 set은 이런게 어려움
            System.out.println(s);
        }
        // List인터페이스는 순서에 따라 저정하고 중복을 허용함
        // set인터페이스는 순서가 없이 저장하고 중복을 허용하지 않음
        // 그래서 get()은 list에만 있음
    }
}
