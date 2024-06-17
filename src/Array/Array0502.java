package Array;

import java.util.Arrays;
import java.util.Collections;

public class Array0502 {

    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] arr){
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
