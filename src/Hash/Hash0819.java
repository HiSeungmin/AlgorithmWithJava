package Hash;

import java.util.Arrays;
import java.util.HashMap;

// 완주하지 못한 선수
public class Hash0819 {
    public static void main(String[] args) {
        String[] a = {"leo", "kiki", "eden"};
        String[] b = {"eden", "kiki"};
        System.out.println(solution(a,b)); //"leo"

        String[] a2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(a2,b2));

        String[] a3 = {"mislav", "stanko", "mislav", "ana"};
        String[] b3 = {"stanko", "ana", "mislav"};
        System.out.println(solution(a3,b3));
    }
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));
        for (int i = 0; i < completion.length; i++) {

            if (!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[participant.length - 1];
    }
}
