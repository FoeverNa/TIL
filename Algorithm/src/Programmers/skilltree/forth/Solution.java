package Programmers.skilltree.forth;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0 ; i < skill_trees.length; i++){
            char[] tree_arr = skill_trees[i].toCharArray();
            int num=0;
            boolean flag = true;
            for (int j = 0 ; j < tree_arr.length; j++){

                    if( num < skill.indexOf(tree_arr[j])){
                        flag = false;
                        break;
                    } else if(num == skill.indexOf(tree_arr[j])) {
                        num++;
                    }
            }
            if(flag){
                answer++;
            }
        }

        return answer;

    }
}

class Test{
    public static void main(String[] args) {
        String[] arr ={"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new Solution().solution("CBD",arr));
    }
}
