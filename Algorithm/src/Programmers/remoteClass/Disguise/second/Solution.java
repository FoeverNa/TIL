package Programmers.remoteClass.Disguise.second;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String,Integer> table  = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            int value = table.getOrDefault(key, 1);
            table.put(key, ++value);
        }

        for(int i : table.values()){
            System.out.println(i);
        }

        int multi = 1;

       for (Integer i : table.values()){
           multi *= i;
       }

        return multi-1;
    }
}

class Test {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headg" +
                "+ear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        new Solution().solution(clothes1);

//        System.out.println(new Solution().solution(clothes1));
//        System.out.println(new Solution().solution(clothes2));


        int o1 =0;
        int o2 =0;

        System.out.println(Integer.compare(o1, o2));

    }




}