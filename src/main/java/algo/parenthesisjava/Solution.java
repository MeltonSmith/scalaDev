package r.ian.algo.parenthesisjava;

import java.util.Stack;

/**
 * @author Melton Smith
 * @since 21.09.2023
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        Stack<Integer> circles = new Stack<>();
        Stack<Integer> parentheses = new Stack<>();
        Stack<Integer> squares = new Stack<>();
        Stack<Stack<Integer>> pointers = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{' -> {
                    pointers.push(parentheses);
                    parentheses.push(1);
                }
                case '}' -> {
                    if (!pointers.empty() && pointers.pop() == parentheses){
                        parentheses.pop();
                    }
                    else
                        return false;
                }
                case '(' -> {
                    pointers.push(circles);
                    circles.push(1);
                }
                case ')' -> {
                    if (!pointers.empty() && pointers.pop() == circles){
                        circles.pop();
                    }
                    else
                        return false;
                }
                case '[' -> {
                    pointers.push(squares);
                    squares.push(1);
                }
                case ']' -> {
                    if (!pointers.empty() && pointers.pop() == squares){
                        squares.pop();
                    }
                    else
                        return false;
                }
                default -> {}
            }
        }

        return circles.empty() && squares.empty() && parentheses.empty();

    }
}
