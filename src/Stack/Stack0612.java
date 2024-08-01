//주식 가격
package Stack;

import java.util.Arrays;

public class Stack0612 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i <n ; i++) {
            int cnt = 0;
            for (int j = i+1; j <n ; j++) {
                if(prices[j]>=prices[i]) { cnt+=1; }
                else if (prices[j]<prices[i]) { cnt+=1; break; }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}

