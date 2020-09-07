package Programmers.Tile.best;

class TryHelloWorld {

    public int tiling(int n) {
        int a = 1;
        int b = 1;

        for(int i = 0; i <n-1;i++ ){
            int fib = (a+b) % 100000;
            a = b;
            b = fib;
        }
    return b;
    }


}
