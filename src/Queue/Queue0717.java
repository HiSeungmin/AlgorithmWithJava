package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

// 카드 뭉치
public class Queue0717 {
    public static void main(String[] args) {
        String[] a = {"i", "drink", "water"};
        String[] a2 = {"i", "water", "drink"};
        String[] b = {"want", "to"};
        String[] c = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(a,b,c)); // "yes"
        System.out.println(solution(a2,b,c)); // "no"

    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "yes";
        ArrayDeque<String> cardsQ1 = new ArrayDeque<>(Arrays.asList((cards1)));
        ArrayDeque<String> cardsQ2 = new ArrayDeque<>(Arrays.asList((cards2)));
        ArrayDeque<String> cardsQ3 = new ArrayDeque<>(Arrays.asList((goal)));

        while(!cardsQ3.isEmpty()){
            String a = cardsQ1.peekFirst();
            String b = cardsQ2.peekFirst();
            String c = cardsQ3.pollFirst();

            if(a == c){
                cardsQ1.pollFirst();
            } else if (b == c) {
                cardsQ2.pollFirst();
            }else{
                answer = "no";
                break;
            }
        }

        return answer;
    }

}
