package s04.p03;

class Outer{
    static class ClassInner{
        int innerVar = 1;
        static int staticInnerVar =100;

        void innerMethod(){
            Outer outer = new Outer();
            System.out.println(outer.outerVar);  // 객체를 생성한 후에 통해 접근가능. 내부클래스 생성시점에 외부클래스의 객체가 없음
                                               //내부클래스에서 외부클래스의 객체를 생성해야만 멤버변수에 접근할수있다.
            System.out.println(innerVar); //당연가능
        }
    }
    private int outerVar = 2;

}

public class Main {
}
