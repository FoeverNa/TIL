package com.company;

public class Main {

    /**
     * 반복문/조건문 연습
     *
     */


    /**
     *
     */
    public static void main(String[] args) {

        // 예제1

        /**
         * **********
         * **********
         * **********
         * **********
         */

        for(int i = 0 ; i<4 ; i++){
            for(int j =0; j< 10; j ++)
            System.out.print("*");
            System.out.println("");
        }

        //예제2

        /**
         * *
         * **
         * ***
         * ****
         * *****
         */

        for(int i = 0; i<5; i++){
            for(int j =0 ; j < i+1; j++ ){
                System.out.print("*");
            }
            System.out.println("");
        }

        //예제3

        /**
         *     *
         *    **
         *   ***
         *  ****
         * *****
         */


        for(int i = 0; i<5; i++){
            for(int j = 0 ; j < 4-i; j++ ){
                System.out.print(" ");
            }
            for(int p = 0; p<i+1; p++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        //예제 4

        /**
         *     *
         *    ***
         *   *****
         *  *******
         * *********
         */


        for(int i = 0; i<5; i++){
            for(int j =4 ; j > i; j-- ){
                System.out.print(" ");
            }
            for(int p = 0; p<(2*i)+1; p++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        //예제 5

        /**
         *     1
         *    222
         *   33333
         *  4444444
         * 555555555
         */

        for(int i = 0; i<5; i++){
            for(int j =4 ; j > i; j-- ){
                System.out.print(" ");
            }
            for(int p = 0; p<(2*i)+1; p++) {
                System.out.print(i+1);
            }
            System.out.println("");
        }
        // 예제6

        /**
         *     1
         *    212
         *   32123
         *  4321234
         * 543212345
         */

        // 내방법
        for(int i = 0; i<5; i++){
            for(int j =4 ; j > i; j-- ){
                System.out.print(" ");
            }
            for(int p = 0; p<(2*i)+1; p++) {
               if(p>i){
                   continue;
               }
                System.out.print(i+1-p);
            }
            for(int q=0; q<i; q++){
                System.out.print(2+q);
            }
            System.out.println("");
        }

        // 풀이 예시1
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i;j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(j - i > 0 ? j - i + 1 : i - j + 1);
            }
            System.out.println("");
        }

        // 풀이 예시2
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 1; j--) {
                if (j <= i + 1) {
                    System.out.print(j);
                } else {
                    System.out.print(' ');
                }
            }
            for (int j = 1; j <= 5; j++) {
                if (j <= i + 1) {
                    System.out.print(j);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
        
        //다양하게 코드 쓸수있지만 다 쓸 수 있는 코드는 아니다
        //어떤 것이 쓸수 있는 코드인지는 판단능력을 길러야한다.

        /**
         * 369 게임
         * 기본형 (순서대로 다 출력, 짝! 하는거는 3,6,9 나오면 한번만)
         * 1부터 시작해서 20까지
         */


        for(int i = 1; i<= 10; i++){

            if(i % 3 == 0){
                System.out.println("짝!");
            }else {
                System.out.println(i);
            }
        };

        /**
         * 순서대로 다 출력,1 ~ 30까지
         *
         */

        for(int i =1; i<=30 ; i++){
            int num1 = i % 10;
            int num2 = i / 10;
            if(num1 ==3 || num1 ==6 || num1 == 9 ||
               num2 ==3 || num2 ==6 || num2 == 9 ){
                System.out.println("짝!");
            } else{
                System.out.println(i);
            }
        }

        /**
         * 369
         * 5명 같이하고, 내가 1번
         * 3,6,9가 여러개 있으면 해당 횟수만큼 짝!
         * 1 ~ 60;
         */

        for(int i = 1; i<=60; i += 5) {
            int num1 = i % 10;
            int num2 = i / 10;
            int numClap = 0;
            if(num1 ==3 || num1 ==6 || num1 == 9 ) {
                numClap++;
            }
            if(num2 == 3 || num2 ==6 || num2 == 9 ){
                numClap++;
            } if (numClap == 0) {
                System.out.println(i);
            } else{
               for (int j = 0; j <numClap; j++){
                   System.out.print("짝!");
               }
                System.out.println("");
            }
        }

        /**
         * 내가 1번, 8명이 같이 합니다.
         * 짝 을 여러번 해요
         * 10의 배수에는 다같이 만세를 외칩니다.
         * 1 ~99
         */
        for(int i = 1; i<=99; i ++) {
            int num1 = i % 10;
            int num2 = i / 10;
            int numClap = 0;

            if (i % 10 == 0){
                System.out.println("만세!");
                continue;
            }
            if((i-1)% 8 !=0){
                continue;
            }

            if(num1 ==3 || num1 ==6 || num1 == 9 ) {
                numClap++;
            }
            if(num2 == 3 || num2 ==6 || num2 == 9 ){
                numClap++;
            } if (numClap == 0) {
                System.out.println(i);
            } else{
                for (int j = 0; j <numClap; j++){
                    System.out.print("짝!");
                }
                System.out.println("");
            }
        }

    }

}
