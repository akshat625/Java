package stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String input = "v{[9()dwe3]}";
        if (isBalanced(input)) {
            System.out.println("The brackets are balanced.");
        } else {
            System.out.println("The brackets are not balanced.");
        }
    }

    private static boolean isBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else if (ch==')' || ch=='}' || ch==']') {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(!isMatch(top,ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
