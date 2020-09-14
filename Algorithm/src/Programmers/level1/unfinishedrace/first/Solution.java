package Programmers.level1.unfinishedrace.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String[] participant, String[] completion) {

        List<String>  listAll = new ArrayList<>(Arrays.asList(participant));
        List<String> listCom = new ArrayList<>(Arrays.asList(completion));

        Collections.sort(listAll);
        Collections.sort(listCom);


        listCom.add("");
        String answer="";
        for (int i = 0; i < listAll.size(); i++) {
         if(!listAll.get(i).equals(listCom.get(i))){
            answer =  listAll.get(i) ;
            break;
         }

        }
        return answer;

    }
}

class test {
    public static void main(String[] args) {
        String[] participant1 =  {"leo", "kiki", "eden"};
        String[] participant2 =  {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant3 =  {"mislav", "stanko", "mislav", "ana"};

        String[] completion1 = { "eden", "kiki"	};
        String[] completion2 = { "josipa", "filipa", "marina", "nikola"};
        String[] completion3 = { "stanko", "ana", "mislav"};

        System.out.println(new Solution().solution(participant1,completion1));
        System.out.println(new Solution().solution(participant2,completion2));
        System.out.println(new Solution().solution(participant3,completion3));

    }

}