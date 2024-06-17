package Array;

import java.util.*;

public class Array0504 {
    public static void main(String[] args) {
        int[] ans = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(ans)));
    }
    public static int[] solution(int[] arr){
        int examMax = 10000;
        int[] score = {0,0,0};

        int[] p1_pt  = {1,2,3,4,5};
        int[] p2_pt  = {2,1,2,3,2,4,2,5};
        int[] p3_pt  = {3,3,1,1,2,2,4,4,5,5};

        int[] p1 = new int[examMax];
        int[] p2 = new int[examMax];
        int[] p3 = new int[examMax];

        for(int i = 0; i < examMax ; i++) { p1[i] = p1_pt[i%p1_pt.length]; }
        for(int i = 0; i < examMax ; i++) { p2[i] = p2_pt[i%p2_pt.length]; }
        for(int i = 0; i < examMax ; i++) { p3[i] = p3_pt[i%p3_pt.length]; }


        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == p1[i]) score[0] += 1;
            if(arr[i] == p2[i]) score[1] += 1;
            if(arr[i] == p3[i]) score[2] += 1;
        }

        int max = 0;
        for (int i = 0; i <3 ; i++) {
            if(max<score[i]) max = score[i];
        }

        //int max = Arrays.stream(score).max().getAsInt();

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <3 ; i++) {
            if(max==score[i]) ans.add(i+1);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }





//    public static int[] solution(int[] answers){
//        int[][] pattern = {
//                {1,2,3,4,5},
//                {2,1,2,3,2,4,2,5},
//                {3,3,1,1,2,2,4,4,5,5}
//        };
//
//        int[] scores = new int[3];
//
//        for (int i = 0; i <answers.length ; i++) {
//            for (int j = 0; j <pattern.length ; j++) {
//                if(answers[i]==pattern[j][i%pattern[j].length])
//                    scores[j] ++;
//            }
//        }
//        int maxScore = Arrays.stream(scores).max().getAsInt();
//
//        ArrayList<Integer> answer = new ArrayList<>();
//        for (int i = 0; i <scores.length ; i++) {
//            if(scores[i] == maxScore)
//                answer.add(i+1);
//        }
//        return answer.stream().mapToInt(Integer::intValue).toArray();
//    }
}
