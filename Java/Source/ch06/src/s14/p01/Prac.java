package s14.p01;

public class Prac {
    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print("1");
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print("2");
            }
        });

        threadOne.start();
        threadTwo.start();
        System.out.println("Done!");
    }

}
