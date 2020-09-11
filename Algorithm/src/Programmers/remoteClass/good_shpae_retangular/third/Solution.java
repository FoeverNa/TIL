package Programmers.remoteClass.good_shpae_retangular.third;

class Solution {

    public int gcd (int x, int y){
        if(y ==0 ){
            return x;
        } else{
            return gcd(y,x%y);
        }

    }

    public long solution(int w, int h) {
        long answer = 1;

        return ((long)w * (long)h) - ((long)w + (long)h-gcd(w,h)) ;
    }
}

class SquaresTest{

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 12));
    }

}