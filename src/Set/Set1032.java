package Set;
import java.util.*;
//영어 끝말잇기
public class Set1032 {

    public static void main(String[] args) {
//        int n = 3;
//        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"} ;
//        int n = 5;
//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"} ;
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"} ;

        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char last_word = words[0].charAt(words[0].length()-1);

        for (int i = 1; i < words.length; i++) {
            String w = words[i];
            if(last_word!=w.charAt(0) || set.contains(w)){
                answer[0] = (i+1)%n==0?n:(i+1)%n;
                answer[1] = i/n + 1;
                return answer;
            }
            set.add(w);
            last_word = w.charAt(w.length()-1);
        }

        return answer;
    }
}
