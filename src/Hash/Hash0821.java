package Hash;

import java.util.*;

//오픈 채팅방
public class Hash0821 {
    public static void main(String[] args) {

        String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(a)));
    }
    public static String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        ArrayList<String> lst = new ArrayList<>();

        for (String str : record) {
            String[] dStr = str.split(" ");

            switch(dStr[0]){
                case "Enter":
                    map.put(dStr[1], dStr[2]);
                    lst.add(dStr[1]+"/님이 들어왔습니다.");
                    break;
                case "Leave":
                    lst.add(dStr[1]+"/님이 나갔습니다.");
                    break;
                case "Change":
                    map.replace(dStr[1], dStr[2]);
                    break;
            }
        }

        String[] answer = new String[lst.size()];
        int i = 0;
        for(String s : lst){
            //System.out.println(s);
            String[] n = s.split("/");
            n[0] = map.get(n[0]);
            answer[i] = n[0]+n[1];
            i++;
        }

        return answer;
    }

}
