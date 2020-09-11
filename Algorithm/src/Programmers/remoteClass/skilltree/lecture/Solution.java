package Programmers.remoteClass.skilltree.lecture;

/**
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop:
        for (String tree : skill_trees) {
            List<Integer> list = new ArrayList<>();
            for (char s : tree.toCharArray()) {
                int index = skill.indexOf(s);
                if (index >= 0) {
                    list.add(index);
                }
            }
            if (list.size() > 0 && list.get(0) != 0) {
                continue;
            }
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) + 1 != list.get(i)) {
                    continue loop;
                }
            }
            answer++;
        }
        return answer;
    }
}

class skilltreeTest{

    public static void main(String[] args) {
        String arr[] = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new Solution().solution("CBD", arr));//1번
    }
}

