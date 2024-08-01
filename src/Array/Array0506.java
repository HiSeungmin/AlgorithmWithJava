package Array;

import java.util.*;
import java.util.stream.Collectors;

public class Array0506 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(5,arr)));
        int[] arr2 = {4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(solution(4,arr2)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer   = new int[N];
        int[] stageCnt = new int[N];
        int pCnt = stages.length; // 사람수

        Map<Integer, Double> failPercent = new HashMap<>();

        for (int i = 0; i < pCnt; i++) { // 스테이지 갯수
            if (stages[i] < N + 1) stageCnt[stages[i] - 1]++;
        }
        //System.out.println(Arrays.toString(stageCnt));

        for (int i = 0 ; i < stageCnt.length; i++) {
            if (pCnt == 0) {
                failPercent.put(i, 0d);
                continue;
            }
            failPercent.put(i, (double)stageCnt[i] / (double)pCnt);
            pCnt -= stageCnt[i];
        }

        for (int i = 0; i < N; i++) {
            double max = -1;
            int maxKey = 0;

            for (int key : failPercent.keySet()) {
                if (max < failPercent.get(key)) {
                    max = failPercent.get(key);
                    maxKey = key;
                }
            }

            answer[i] = maxKey + 1;
            failPercent.remove(maxKey);
        }

        return answer;
    }
}
