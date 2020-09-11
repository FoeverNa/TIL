package Programmers.remoteClass.BestAlbum.second;

import java.util.*;

class Nod implements Comparable<Nod>{
    String key;
    int value;
    int index;

    public Nod(String key, int value, int index) {
        this.key = key;
        this.value = value;
        this.index = index;
    }

    public Nod(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Nod nod) {
       return -(this.value - nod.value);
    }

    @Override
    public String toString() {
        return "key= " + key + " value= " + value ;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genresMap = new HashMap<>();
        List<Nod> songList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            int value = plays[i];
            int currentValue = genresMap.getOrDefault(key, 0);

            genresMap.put(key, currentValue + value);
            songList.add(new Nod(key, value, i));
        }

        List<Nod> sumList = new ArrayList<>();

       for (String key : genresMap.keySet()){
               int value = genresMap.get(key);
           sumList.add(new Nod(key, value));

       }

        Collections.sort(sumList);
        Collections.sort(songList);

        System.out.println(sumList);
//        System.out.println(songList);

        List<Integer>  bests = new ArrayList<>();

        while(!sumList.isEmpty()){
           String key = sumList.remove(0).key;

           int num =0;
           for (int i = 0; i < songList.size(); i++) {
                if(songList.get(i).key.equals(key)){
                    bests.add(songList.get(i).index);
                    num++;
                }
               if(num==2){
                   break;
           }

           }

        }

        int[] answer = new int[bests.size()];
        for (int i = 0; i < bests.size(); i++) {
            answer[i] = bests.get(i);

        }
        return answer;

    }
}

class Test {
    public static void main(String[] args) {

        String[] strArr = {"classic", "pop", "classic", "classic", "pop"};
        int[] intArr = {500, 600, 150, 800, 2500};
        Solution sol = new Solution();

//        sol.solution(strArr, intArr);

        int [] solArr = sol.solution(strArr, intArr);

         for (int i : solArr){
             System.out.println(i);
         }


    }
}