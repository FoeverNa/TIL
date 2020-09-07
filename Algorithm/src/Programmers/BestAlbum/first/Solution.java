package Programmers.BestAlbum.first;

import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<String> gens = new ArrayList<>();

        gens.add(genres[0]);

//        System.out.println(gens.get(1));

        for(int i = 0; i < genres.length; i++){
            boolean flag = true;

            for (int j =0; j < gens.size(); j++ ){
                if (genres[i].equals(gens.get(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                gens.add(genres[i]);
            }
        }

        int [] gSum = new int[gens.size()];

        for(int i = 0; i < plays.length; i++){
            for(int j = 0; j< gens.size(); j++){
                if(genres[i].equals(gens.get(j))){
                    gSum[j] += plays[i];
                    break;
                }
            }
        }

         







        return answer;


    }
}

class Test {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution sol  = new Solution();

        sol.solution(genres,plays);

//        int[] arr = new Solution().solution(genres,plays);
//
//        for (int i=0; i<arr.length; i++ ){
//            System.out.printf("%d, ",arr[i]);
//
        }
    }

