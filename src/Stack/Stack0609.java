// 10진수를 2진수로 변환하기
package Stack;

import java.util.*;

public class Stack0609 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }
    public static String solution(int i){
        Stack<Integer> stack = new Stack<>();
        while(i>0){
            stack.push(i%2);
            i/=2;
        }

        StringBuffer s = new StringBuffer();
        while(!stack.isEmpty()){
            s.append(stack.pop());
        }
        return s.toString();
    }
}
