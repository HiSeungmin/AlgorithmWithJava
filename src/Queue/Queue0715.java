package Queue;

import java.util.ArrayDeque;

// 요세푸스 문제
public class Queue0715 {
    public static void main(String[] args) {

    }
    public static int solution(int N, int K){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(i);
        }

        while(deque.size()>1){
            for (int i = 0; i <K-1 ; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        return deque.pollFirst();
    }
}
