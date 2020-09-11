package Programmers.remoteClass.good_shpae_retangular.fourth;

class Solution {
    public int gcd(int x, int y){
        if(y == 0){
            return x;
        } else {
            return gcd( y,  x%y);
        }

    }

    public long solution(int w, int h) {
        long answer = 1;
        long gcd = (long)gcd(w, h);
        answer = ((long)w * (long)h) -((long)w + (long)h-gcd );


        return answer;
    }
}

class Test{

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 12));
    }
}