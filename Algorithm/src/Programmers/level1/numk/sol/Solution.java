package Programmers.level1.numk.sol;


import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

     int[] answer = new int[commands.length];

     for (int i =0; i< commands.length; i++){

         int [] temp = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
         Arrays.sort(temp);

         answer[i] = temp[commands[i][2]-1];


     }
        return  answer;

    }
}

class Test{
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

//        new Solution().solution(array, commands);

        for(int i : new Solution().solution(array, commands)){
            System.out.println(i);
        }
    }


}