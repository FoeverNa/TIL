package com.company;

/**
 * N-D Array 연습
 */
public class Main {

    public static void main(String[] args) {
        int [][] matA = {{1,2,3},{3,4,5}};
        int [][] matB = {{3,4,5},{1,4,2}};
        int [][] mulMat = new int[matA.length][matA[0].length];

        // 1. matA + maB를 구하고, 출력하시오
        // 내풀이

        for(int i=0; i<matA.length;i++){
            for(int j=0; j<matA[i].length; j++){
                mulMat[i][j] = matA[i][j] * matB[i][j];
                System.out.printf("%d ",mulMat[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

        // 2. matA를 Transpose하고 출력하시오.
        // 행열이 반전되어서 만들어지는 배열
        // ex
        // 1 2 3
        // 4 5 6

        // 1 4
        // 2 5
        // 3 6


        int[][] matA_ = new int[matA[0].length][matA.length];

        for(int i = 0 ; i < matA.length; i++){
            for (int j = 0; j < matA[0].length;j++){
                matA_[j][i] = matA[i][j];
            }
            System.out.println("");
        }
        for(int[] array: matA_){
            for(int val : array){
                System.out.printf("%d ",val);
            }
            System.out.println("");
        }
    }
}
