package Hash;

import java.util.*;
//베스트 앨범 : 장르별 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시
/*
* 속한 노래가 많이 재생된 장르를 먼저 수록한다.
* 장르 내에서 많이 재생된 노래를 먼저 수록한다.
* 장르 내에서 재생 횟수가 같은 노래 중에서는 고유번호가 낮은 노래를 먼저 수록한다.
* */
public class Hash0822 {

    public static void main(String[] args) {
        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        int[] b = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(a,b))); //[4, 1, 3, 0]
    }



    public static int[] solution(String[] genres, int[] plays){

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); // pop=3100, classic=1450
        }
        //System.out.println(map);

        ArrayList<String> genre = new ArrayList<>(map.keySet());    // key값만 가져와서 genre에 넣어준다
        genre.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1))); // 내림차순으로 정렬

        ArrayList<Integer> list = new ArrayList<>(); // 인덱스 저장
        for(int i = 0; i < genre.size(); i++) {

            String g = genre.get(i);

            // 현재 장르 중 play 횟수가 가장 큰 인덱스 ->
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            // 현재 장르 중 play 횟수가 두 번째로 큰 인덱스
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            list.add(firstIdx);
            if(secondIdx >= 0) list.add(secondIdx);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
