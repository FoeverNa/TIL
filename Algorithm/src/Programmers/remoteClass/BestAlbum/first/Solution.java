package Programmers.remoteClass.BestAlbum.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<String> gens = new ArrayList<>();
        HashMap<String, Integer> hashMap= new HashMap<>();



        for(int i = 0; i < genres.length; i++){

            if (!hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i],plays[i]);
            } else{
                int sum  = hashMap.get(genres[i]) + plays[i];
                hashMap.remove(genres[i]);
                hashMap.put(genres[i],sum);
            }
        }

        Iterator<String> it = hashMap.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            int i = hashMap.get(key);
            System.out.println(i);
        }



//        int [] gSum = new int[gens.size()];
//
//        for(int i = 0; i < plays.length; i++){
//            for(int j = 0; j< gens.size(); j++){
//                if(genres[i].equals(gens.get(j))){
//                    gSum[j] += plays[i];
//                    break;
//                }
//            }
//        }

        return answer;


    }
}

class Test {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution sol  = new Solution();

        sol.solution(genres,plays);

        }
    }

