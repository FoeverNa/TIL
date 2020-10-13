package s01.p01.prac;



class Singleton {
    private static Singleton instance;// private으로 선언

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {

            instance = new Singleton();
        }
        return instance;
    }
}

public class Main {
}
