package Hash;

import java.util.*;

// 신고 결과 받기
public class Hash0823 {
    public static void main(String[] args) {
        String[] a = {"muzi", "frodo", "apeach", "neo"};
        String[] b = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(a, b, k))); // [2, 1, 1, 0]

        String[] a2 = {"con", "ryan"};
        String[] b2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        System.out.println(Arrays.toString(solution(a2, b2, k2))); // [2, 1, 1, 0]

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> mailMap = new HashMap<>(); // 받아야되는 메일개수
        Map<String, ArrayList<String>> map = new HashMap<>(); // key = 신고받는 사람, value = 신고한 사람
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < report.length; i++) { // 0: 신고자, 1:신고당한자
            String[] lst = report[i].split(" ");
            ArrayList<String> strLst = map.getOrDefault(lst[1], new ArrayList<>());
            if(!strLst.contains(lst[1])) { strLst.add(lst[0]); }
            map.put(lst[1], strLst);
            if(strLst.size()>=k && !list.contains(lst[1])) { list.add(lst[1]); }
        }

        for(int i = 0; i < list.size(); i++) {
            for(String s : map.get(list.get(i))) {
                mailMap.put(s,mailMap.getOrDefault(s,0)+1);
            }
        }

        //System.out.println(map);

        int[] answer = new int[id_list.length];
        for (int i = 0; i <id_list.length ; i++) {
            answer[i] = mailMap.getOrDefault(id_list[i],0);
        }

        //System.out.println(mailMap);

        return answer;
    }
}
