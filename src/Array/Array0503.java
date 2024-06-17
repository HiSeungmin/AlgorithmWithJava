package Array;

import java.util.*;

public class Array0503 {
    public static void main(String[] args) {
        //int[] numbers = {2,1,3,4,1};
        int[] numbers = {5,0,2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] arr){
        HashSet<Integer> arrSet = new HashSet<>();
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                arrSet.add(arr[i]+arr[j]);
            }
        }
        return arrSet.stream().sorted().mapToInt(Integer::intValue).toArray();

    }
}
