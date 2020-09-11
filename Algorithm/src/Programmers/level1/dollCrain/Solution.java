package Programmers.level1.dollCrain;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {

        List<Integer> basket = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {

            for (int j =0; j < board.length; j++){
                if (board[j][moves[i]-1] != 0 ){
                    basket.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }

        int popNum = 0;
        boolean isPop =true;
        while(isPop){
            isPop =false;
            int previousDoll = 0;
            for (int i = 0; i < basket.size(); i++) {
                if(basket.get(i)==previousDoll){
                    popNum++;
                    basket.remove(i);
                    basket.remove(i-1);
                    isPop =true;
                    break;
                }else{
                    previousDoll =basket.get(i);
                }
            }
        }

        if(popNum>0){
            return popNum*2;
        } else{
            return 0;
        }
    }
}

class Test{
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};

        System.out.println(new Solution().solution(board, move));
    }



}