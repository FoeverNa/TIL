package s14;

public class ThreadTest {
    public static void main(String[] args) {
//        Thread threadOne = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                System.out.print("1");
//            }
//        });
//
//        Thread threadTwo = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                System.out.print("2");
//            }
//        });
//
//        threadOne.start(); // 스타트 매서드를 사용해줘야 실행이 된다
//        threadTwo.start();
//        System.out.println("Done!");
//        //Done!
//        //11111111112222222222
//        // 이 순서는 아무도 보장할 수 가 없다
//        // 스레드가 동시에 도는게 아니고 one이돌았다가 two가 돌았다가 한다

        // 우선순위

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("1");
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("2");
            }
        });

        threadOne.setPriority(1);
        threadOne.setPriority(10);

        threadOne.start(); // 스타트 매서드를 사용해줘야 실행이 된다
        threadTwo.start();
        System.out.println("Done!");
        //Done!
        //1111111111122222222222222222222222222222222222222
        // Priotiry가 설정되어있다고해도 보장되지 않는다.. 
        // 그냥 OS가 노력을 하는거래... 고맙다 OS야 => 자바수준에서의 이해, system쪽에 의해선 또 다른일
    }
}
