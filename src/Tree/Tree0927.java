package Tree;

import java.util.Arrays;
import java.util.*;

// 다단계 칫솔 판매
public class Tree0927 {
    public static void main(String[] args) {
//        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//        String[] seller = {"young", "john", "tod", "emily", "mary"};
//        int[] amount = {12, 4, 2, 5, 10};
//        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount))); // [360, 958, 108, 0, 450, 18, 180, 1080]

        String[] enroll   = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller   = {"sam", "emily", "jaimie", "edward"};
        int[] amount      = {2, 3, 5, 4};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount))); // [360, 958, 108, 0, 450, 18, 180, 1080]


    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        Map<String, String> map   = new HashMap<>(); // 부모노드 저장
        Map<String, Integer> cash = new HashMap<>(); // 돈 저장

        for (int i = 0; i < enroll.length ; i++) {
            map.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length ; i++) {
            String s = seller[i];
            int a = amount[i] * 100;
            while(true){
                cash.put(s, cash.getOrDefault(s,0)+(a - (int)(a * 0.1))); // indexOf()
                a = (int)(a * 0.1);

                if(!map.containsKey(s) || map.get(s).equals("-") || a<1) break; // a=0일 경우
                s = map.get(s);
            }

        }
        for (int i = 0; i <enroll.length ; i++) {
            answer[i] =cash.containsKey(enroll[i])?cash.get(enroll[i]):0;
        }

        return answer;
    }










//    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//
//        int[] answer = new int[enroll.length];
//
//        Map<String, String> map   = new HashMap<>();
//        Map<String, Integer> cash = new HashMap<>();
//
//        for (int i = 0; i < enroll.length ; i++) {
//            map.put(enroll[i], referral[i]);
//        }
//
//        for (int i = 0; i <seller.length ; i++) {
//            String s = seller[i];
//            int a    = amount[i]*100;
//
//            while(true){cash.put(s,cash.getOrDefault(s,0)+(a-(int)(a*0.1)));
//                a = (int)(a*0.1);
//                if(!map.containsKey(s) || map.get(s).equals("-") || a<1) break;
//                s = map.get(s);
//            }
//        }
//        for (int i = 0; i <enroll.length ; i++) {
//            answer[i] =cash.containsKey(enroll[i])?cash.get(enroll[i]):0;
//        }
//
//        return answer;
//    }

}
