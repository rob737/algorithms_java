package leetcode.stack;

import java.util.Stack;

public class BalancedBracket {

    private static String exp = "(({}))[][";

    public static void main(String[] args) {
        boolean result = balanceParanthesis(exp);
        System.out.printf("isBalanced : %s ", result);
    }

    private static boolean balanceParanthesis(String exp) {
        if(exp.length() %2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();

        for(char ch : exp.toCharArray()){
            if(ch == '(')
                stack.push(')');
            else if(ch == '{')
                stack.push('}');
            else if(ch == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop()!= ch)
                return false;
        }
        return stack.isEmpty();
    }
}
