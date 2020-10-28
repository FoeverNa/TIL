package s01.p01.prac;



class Singleton {
    private static Singleton instance;

    private Singleton() {}// getInstance에서 생성하기 위해 기본생성자 만들어놨구나!

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String toString() {

        return "Im a Singleton";
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }

}
