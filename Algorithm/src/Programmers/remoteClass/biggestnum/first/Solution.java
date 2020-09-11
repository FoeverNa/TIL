package Programmers.remoteClass.biggestnum.first;

import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {

        PriorityQueue<String> pq = new PriorityQueue<String>((o1, o2) -> {
            if(o1 == o2){
                return 0;
            } else if( Integer.parseInt(o1+o2) < Integer.parseInt(o2+o1)){
                return  1;
            } else{
                return -1;
            }
        } );

        for(int num : numbers){
            pq.offer(Integer.toString(num));
        }

        assert pq.peek() != null;
        if(pq.peek().equals("0")){
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        while(!pq.isEmpty()){

            builder.append(pq.poll());

        }

        return builder.toString();
    }
}

class test{

    public static void main(String[] args) {

        int [] arr1 = {0,0,0,0};
        int [] arr2 = {3, 30, 34, 5, 9};

        System.out.println(new Solution().solution(arr1));
        System.out.println(new Solution().solution(arr2));
    }
}