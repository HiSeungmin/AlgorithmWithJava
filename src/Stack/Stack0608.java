package Stack;

import java.util.*;

public class Stack0608 {
    public static void main(String[] args) {
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
    public static boolean solution(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='(')
                stack.push("(");
            else if(s.charAt(i)==')'&&stack.isEmpty()==true)
                return false;
            else
                stack.pop();

        }

        if(stack.isEmpty()==true) return true;
        else return false;
    }
}
