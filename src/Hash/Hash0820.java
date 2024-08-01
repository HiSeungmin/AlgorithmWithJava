package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//할인 행사
public class Hash0820 {
    public static void main(String[] args) {
        String[] a = {"banana", "apple", "rice", "pork", "pot"};
        int[] b = {3, 2, 2, 2, 1};
        String[] c = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(a,b,c)); // 3
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i],number[i]);
        }
        System.out.println(map);

        for (int i = 0; i < discount.length-days+1 ; i++) {

            Map<String, Integer> map2 = new HashMap<>();
            for (int j = i; j < i+days; j++) {
                map2.put(discount[j],map2.getOrDefault(discount[j],0)+1);
            }
            System.out.println(map2);

            if(map2.equals(map)) answer += 1;

        }
        return answer;
    }
}
