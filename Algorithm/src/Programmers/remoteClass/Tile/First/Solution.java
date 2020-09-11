package Programmers.remoteClass.Tile.First;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] integers = new int[n + 1];
        integers[1] = 1;
        integers[2] = 2;
        for (int i = 3; i < integers.length; i++) {
            integers[i] = (integers[i - 1] + integers[i - 2])  ;
        }
        answer = integers[n] % 1000000007;


//        if(n==1){
//            answer = 1;
//        }else if(n == 2){
//                answer = 2;
//        } else{
//            answer = solution(n-1) + solution(n-2) ;
//        }

        return answer;

    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(new Solution().solution(60000));
    }
}