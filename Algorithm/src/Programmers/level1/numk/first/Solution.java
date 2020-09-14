package Programmers.level1.numk.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        List<Integer> list ;

        int[] answer = new int[commands.length];

       for (int i = 0; i < commands.length; i++){
           list =  new ArrayList<>();
           for (int j =(commands[i][0]-1) ; j < commands[i][1]; j++){
               list.add(array[j]);
           }
           Collections.sort(list);
           answer[i] = list.get(commands[i][2]-1);

//           for (int w : list){
//               System.out.print(w);
//           }
//           System.out.println("");
       }



        return answer;
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