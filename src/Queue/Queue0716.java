package Queue;

import java.util.ArrayList;
import java.util.Arrays;

// 기능 개발
public class Queue0716 {
    public static void main(String[] args) {
        int[] progresses1 = {93,30,55};
        int[] speeds1 = {1,30,5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses1,speeds1)));
        System.out.println(Arrays.toString(solution(progresses2,speeds2)));
    }


    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];

        for (int i = 0; i < n ; i++) {
            //days[i] = ((100-progresses[i])/speeds[i]) + ((100-progresses[i])%speeds[i]>0?1:0);
            days[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
        }

        int cnt = 1;
        int p = days[0];
        for (int i = 1; i < n ; i++) {
            if(p>=days[i]) cnt+=1;
            else{
                answer.add(cnt);
                cnt = 1;
                p = days[i];
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(Integer::intValue).toArray(); // stream 을 많이 쓰면 안좋으니 다른 방법 생각해보기
    }
}
