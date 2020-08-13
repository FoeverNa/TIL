package pp;

interface Foo1 {

    void Bar1();

    default void defaulMethod(){
        System.out.println("예에");

    }
}

interface Foo2 {

    void Bar2();
}
interface Foo3 {

    void Bar3();
}

class Bar implements Foo1, Foo2, Foo3{

    @Override
    public void Bar1() {

    }

    @Override
    public void Bar2() {

    }

    @Override
    public void Bar3() {

    }

}

public class Main {
}
