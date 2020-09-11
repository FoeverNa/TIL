package Programmers.remoteClass.BestAlbum.leture;

/**
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며,
 * 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */

import java.util.*;

class Node implements Comparable<Node>{
    String key;
    int value;
    int index;

    public Node(String key, int value, int index) {
        this.key = key;
        this.value = value;
        this.index = index;
    }

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        return -Integer.compare(this.value,node.value); //- 붙이면 내림차순, +면 오름차순
    }
    public String toString() {
        return "(" + key + ", " + value + ", " + index + ")";
    }
}


class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> sumMap = new Hashtable<>();
        List<Node> list = new LinkedList<>();

        for (int i = 0; i < genres.length; i ++) {
            String key = genres[i];
            int value = plays[i];

            int currentValue = sumMap.getOrDefault(key, 0);
            sumMap.put(key, currentValue + value);
            list.add(new Node(key, value, i));
        } //장르별로 plays수를 합치는 방법

        List<Node> sumList = new LinkedList<>(); //ArrayList써도됨
        sumMap.entrySet();//key끼리 value끼리 묵여있는것을 key-value단위이 엔트리로 묵어줌,

        for(Map.Entry<String, Integer> entry: sumMap.entrySet()){
            sumList.add(new Node(entry.getKey(), entry.getValue()));
        }

        Collections.sort(sumList);
        Collections.sort(list);

//        System.out.println(list); // 확인용 출력 //toString 재정의해야함

        List<Integer> bests = new ArrayList<>();

        while(!sumList.isEmpty()){
            String key = sumList.remove(0).key;// getKey로 하는게 더엄밀함
            int num =0;
            for(Node node: list){
                if(node.key.equals(key)){
                    bests.add(node.index);
                    num++;
                }
                if(num ==2){
                    break;
                }
            }
        }


        int[] answer = new int[bests.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = bests.get(i);
            }
        return answer;
    }
}
