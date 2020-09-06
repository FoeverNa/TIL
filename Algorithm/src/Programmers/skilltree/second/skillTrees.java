package Programmers.skilltree.second;

/**
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다
 */
public class skillTrees {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) { // 배열 원소만큼 돌릴거임
            int chk = 0; //skill_trees가 skill이 아니면 증가 안시킴
            boolean flag = true; // false 가 되면 탈출. skill과 관련없는 문자면  true 유지
            String[] skillArr = skill_trees[i].split(""); // 스킬중에 없으면 -1 찍어서 아무것도 안할거임!!!
//            for(String skillChk : skillArr) { // 여기선 foreach문 쓰는게 더 편한것같은데...
            for (int j = 0; j < skillArr.length; j++) {
                String skillChk = skillArr[j]; // foreach 쓰면 여긴 없어도 됨
                if (chk == skill.indexOf(skillChk)) {
                    chk++;
                } else if (chk < skill.indexOf(skillChk)) {
                    // skill이랑 skillChk 문자랑 비교해서 문자 위치가 다르면... 탈출
                    // skill은 CBD 일때 skilltrees가 XCBT라면 X와 T는 -1로 조건문 안탐
                    // 스킬의 C는 0. chk가 0보다 작을 수 없기때문에 chk ++ 시키고 다음 문자 체크함
                    // 중복 문자 들어와도 chk는 이전보다 하나 증가된 값이고 원소위치는 변하지 않아서 chk 증가 안됨
                    flag = false;
                    break;
                }
            }
            //if(flag) 도 가능함
            if (flag == true) { // flag 가 true 일때 answer 증가
                answer++;
            }
        } // end for
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"BACDE", "CBADF", "AECB", "BDA","GQEW"};
        skillTrees skillTree = new skillTrees();
        skillTree.solution("CBD", arr);
    }
}