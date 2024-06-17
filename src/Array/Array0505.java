package Array;

import java.util.Arrays;

public class Array0505 {
    public static void main(String[] args) {
        int[][] r1 = {{2,3,2},{4,2,4},{3,1,4}};
        int[][] r2 = {{5,4,3,},{2,4,1},{3,1,1}};
        int[][] res = solution(r1, r2);
        for (int i = 0; i <3 ; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int m = arr1[0].length;
        int y = arr2[0].length;

        int[][] answer = new int[x][y];

        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                for (int k = 0; k <m ; k++) {
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }

            }
        }

        return answer;
    }
}
