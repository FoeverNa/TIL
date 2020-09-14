package Programmers.remoteClass.biggestnum.leture;

/**
 * 문제 설명
 *  0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 *  예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 *  0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 *  순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 *  제한 사항
 *  numbers의 길이는 1 이상 100,000 이하입니다.
 *  numbers의 원소는 0 이상 1,000 이하입니다.
 *  정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */


import java.util.PriorityQueue;

//class Node implements Comparable<Node>{
//    String number;
//
//    public Node(String number) {
//        this.number = number;
//    }
//
//    @Override
//    public int compareTo(Node o) {
//        //여기다 비교하는 방법 하면됨
//        return 0;
//    }
//}
class Solution {
    public String solution(int[] numbers) {

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else {
                if (Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });



        for (int number : numbers){
            pq.offer(String.valueOf(number));
        }
//        for(String str : pq){
//            System.out.println(str);
//        }


        assert pq.peek() != null; // assert는 null인지 확인해줌
        if (pq.peek().equals("0")){
            return "0";
        } //입력값이 모두 0인경우를 처리해주는 부분..

        StringBuilder builder = new StringBuilder();

        while(!pq.isEmpty()){
            builder.append(pq.poll());

        }
        // 원래 STring 구현하는 방법이 있는데 그것을 무시하고 우리가 지정한 방식으로 해라

        return builder.toString();

    }
}

class Test{
    public static void main(String[] args) {
        int[] arr1 = {6, 10, 2};
        int[] arr2 = {3, 30, 34, 5, 9};

        System.out.println(new Solution().solution(arr1));
        System.out.println(new Solution().solution(arr2));

    }

}

