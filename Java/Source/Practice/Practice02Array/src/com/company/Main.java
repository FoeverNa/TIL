package com.company;

/**
 * Array 연습
 */

public class Main {

    public static void main(String[] args) {
        int[] integers = {4, 5, 7, 34, 52, 32, 67, 12, 44};
        //1. 위 배열에서 최대값을 찾는 프로그램을 작성하시오.

        int maxVal = integers[0];
        for (int i = 0; i < integers.length; i++) {
            maxVal = integers[i] > maxVal ? integers[i] : maxVal;
        }
        System.out.println("최대값 : "+maxVal);

        maxVal = integers[0];
        for (int val : integers) {
            maxVal = maxVal > val ? maxVal : val;
        }
        System.out.println("최대값 : "+maxVal);

        // 2. 위 배열에서 2번재로 큰 값을 찾는 포르그램을 작성 하시오.

        // 내 방법
        int secondVal = integers[0];
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == maxVal) {
                continue;
            }else {
                secondVal = integers[i] > secondVal ? integers[i] : secondVal;
            }
        }
        System.out.println("두번째로 큰 값 :"+secondVal);
        //Enhanced for활용
        secondVal = integers[0];
        for(int val : integers) {
            if (val == maxVal) {
                continue;
            } else {
                secondVal = secondVal > val ? secondVal : val;
            }
        }
        System.out.println("두번째로 큰 값 :"+secondVal);


        //풀이 예시
//        int [] maxVals = new int[2];
//
//        for(int val : integers) {
//            if(maxVals[0] < val) {
//                maxVals[1] = maxVals[0];
//                maxVals[0] = val;
//            }else if(maxVals[1] < val){
//                maxVals[1] = val;
//            }
//        }
//        System.out.println("두번째로 큰 값 :" + maxVals[1]);

        int[] maxVals = new int[2];


        for (int val : integers) {
            if(maxVals[0] < val){
                maxVals[1] = maxVals[0];
                maxVals[0] = val;
            } else if(maxVals[1] < val){
                maxVals[1] = val ;
            }

        }



    }
}
