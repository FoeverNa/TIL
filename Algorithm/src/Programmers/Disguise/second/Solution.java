package Programmers.Disguise.second;

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

        int multi = 1;
       for (Integer i : table.values()){
           multi *= i;
       }

        return multi-1;
    }
}