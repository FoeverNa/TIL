package Programmers.good_shpae_retangular.second;

public class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        //long square = w + h;
        //long squareAll = w * h; // 전체 사각형 개수
        // 정수형을 문자열로 바꿨다가 문자열을 Long 객체로 변환함.... tlqkf
        // 자동형변환이 되긴 되는데 소수점 다 잘라먹어서 값 고대로 long 변환해야하니까 일케 함..
        // 더 쉬운 방법 없나
        long wl = new Long(w);
        long hl = Long.valueOf(h);
//        long square = wl + hl; // 밑에 while문에서 값 바꿔주니까 미리 기존 값 일케 저장해둬야됨!!
//        long squareAll = wl * hl; // 전체 사각형 개수
        long gcd;

        //long max = wl >= hl ? wl : hl; // max = 12, min = 8;
        //long min = wl < hl ? wl : hl;  // 8
        //while(min != 0) {
        //long temp = max % min;
        //max = min;
        //min = temp;
        //}
        /**
         * 유클리드 알고리즘
         * 큰 수를 작은 수로 나머지가 0이 될 때까지 나눔
         * 0이 되면 작은 수가 최대 공약수 (Greatest Common Divisor)
         * 작은 수가 0이 아니라면 0이 될 때까지 반복
         */
        while(wl != 0 ) {
            long temp = hl % wl;
            hl = wl;
            wl = temp;
        }
        gcd = hl;
        hl =h;
        wl =w;
        answer = (hl*wl) - ((hl+wl) - gcd);
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        long a = sol.solution(8, 12);
        System.out.println(a);
    }
}