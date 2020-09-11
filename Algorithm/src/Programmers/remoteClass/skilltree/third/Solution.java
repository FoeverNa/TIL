package Programmers.remoteClass.skilltree.third;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        here:
        for(String tree : skill_trees){

            List<Integer> list = new ArrayList<>();


            for (char ch : tree.toCharArray()){
                int index =skill.indexOf(ch);
                if(index>-1){
                    list.add(index);
                }
            }
            if( list.size()> 0 && list.get(0) !=0 ){
                continue;
            }

            for(int i = 1; i < list.size() ; i++){
               if( (list.get(i-1) +1) != list.get(i)){
                   continue here;
               }
            }
            answer++;
        }

        return answer;
    }
}

class skillTset{


    public static void main(String[] args) {
        String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new Solution().solution("CBD", arr));
    }


}