package Programmers.level1.unfinishedrace.sol;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i ;
        for (i = 0; i < completion.length; i++) {
         if(!participant[i].equals(completion[i])){
             return participant[i];
         }

        }

        return participant[i];

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