package s06.prac;

import java.lang.reflect.InvocationTargetException;

//class Bar{
//        int x;
//
//        void method(){
//            int x =0;
//
//        }
//}

//interface IFoo{
//    void method(String x , String y);
//}

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        class Bar{}
//
//        Bar bar = new Bar();
//
//        System.out.println(bar.getClass());
//    }
//
//        int[] ints = {1,2,3,4,4,5,6,2,};
//
//        List<int[]> list = Arrays.asList();


//
//        class Bar{
//            public void methodA(){
//                System.out.println("methodA is called.");
//            }
//            public void methodB(){
//                System.out.println("methodB is called.");
//            }
//        }
//
//        Bar bar = new Bar();
//
//        Class barClass = bar.getClass();
//
//        System.out.println(barClass.getName());
//
//        System.out.println(barClass.getDeclaredMethods().length);
//        barClass.getDeclaredMethod("methodA").invoke(bar);
//
//
//

//
//        class Foo{
//            void useIFoo(IFoo iFoo, String x, String y){
//                iFoo.method(x, y);
//            }
//        }
//
//        new Foo().useIFoo((x, y) -> );

//
//        class Complex{
//            private double re, im;
//
//            public Complex(double re, double im) {
//                this.re = re;
//                this.im = im;
//            }
//
//            @Override
//            public String toString(){
//                return String.format(re + " + i" + im);
//            }
//
//            @Override
//            public boolean equals(Object o){
//
//                if( o == this){
//                    return true;
//                }
//
//                if (!(o instanceof Complex)) {
//                    return false;
//                }
//
//                Complex c = (Complex) o;
//
//                return Double.compare(re, c.re) == 0
//                        && Double.compare(im, c.im) ==0;
//            }
//
//        }
//
//
//        Complex c1 = new Complex(10, 15);
//        Complex c2 = new Complex(10, 15);
//        if(c1.equals(c2)){
//            System.out.println("equal");
//        }else{
//            System.out.println("not equal");
//        }
//
//        System.out.println(c1);
//        System.out.println(c2);
//
//        System.out.println(c1.getClass());
//        System.out.println(c1.getClass().getName());
//
//
//
//
//        class Foo{
//            public void methodA(){
//                System.out.println("method A is called.");
//            }
//        }
//
//        Foo foo = new Foo();
//        Class fooClass = foo.getClass();
//
//        System.out.println(fooClass.getName());
//        System.out.println(fooClass.getDeclaredMethods().length);
//        System.out.println(Foo.class.getDeclaredMethod("methodA").invoke(foo));

        System.out.println(Math.abs(-47));

        System.out.println(Math.ceil(1.2312312312313));
        System.out.println(Math.max(4,2));

        System.out.println(Math.random());
        System.out.println(Math.random() < 0.7);

        int count =0;
        for (int i = 0; i < 1000000 ; i++) {
            if(Math.random() < 0.7) {
                count ++;
            }
        }
        System.out.println(count);

        int minVal = 7;
        int maxVal = 14;
        int redInt = (int)(Math.random() * (14 - 7 + 1) + minVal);  // => 0부터 7까지나오게해논거제
        System.out.println(redInt);

        System.out.println(Math.round(1.412f));

        try{
            System.out.println(Math.addExact(Integer.MAX_VALUE, 10));
            System.out.println(Math.subtractExact(Integer.MAX_VALUE, -10));
            System.out.println(Math.multiplyExact(Integer.MAX_VALUE, 4));
        } catch (ArithmeticException e) {
            System.out.println(e);
        }




















    }
}
