package Programmers.skilltree.first;

public class Solution {

    String skill;
    String[] skill_trees;

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

//        if(skill.length()<1 || skill.length()>26){
//            System.out.println("wrong skill name ");
//        }else{
//            this.skill = skill;
//        }
//
//        if(skill_trees.length<1 || skill_trees.length>20){
//            System.out.println("wrong skill_tree");
//        }else{
//            this.skill_trees = skill_trees;
//        }
        for (String skill_tree : skill_trees) {
            boolean isLinked = true;
            int checkNum = 0;

            String[] tree_arr= skill_tree.split("");

            for (int j = 0; j < skill_tree.length(); j++) {
               if(checkNum == skill.indexOf(tree_arr[j])){
                   checkNum++;
                } else if(checkNum <skill.indexOf(tree_arr[j]) ){
                   isLinked=false;
                   break;
               }

            }
            if (isLinked) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println( solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA", "GEWZ"}));


    }
}