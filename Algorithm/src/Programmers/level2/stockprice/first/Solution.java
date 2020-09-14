package Programmers.level2.stockprice.first;

class Solution {

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];


        for(int i =0; i < prices.length; i++){
            int time =0;

            for (int j =i+1; j < prices.length; j++){
                if(prices[i] <= prices[j]){
                    time++;
                } else {
                    time++;
                    break;
                }
            }
            answer[i] = time;

        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] prices2 = {1, 3, 2, 1, 1};

        for(int i : new Solution().solution(prices)){
            System.out.print(i);
        }
        System.out.println("");

        for(int i : new Solution().solution(prices2)){
            System.out.print(i);
        }
        System.out.println("");

    }
}