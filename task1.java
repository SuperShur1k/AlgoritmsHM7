package org.example.lesson7hm;

import java.util.Stack;
// Последовательность ([{}]) является правильной, а последовательности ([)], {()] правильными не являются. Докажите это используя стек!

public class task1 {
    public static void main(String[] args) {
        String sequence1 = "([{}])";
        String sequence2 = "([)]";
        String sequence3 = "{()]";

        System.out.println(sequence1 + " is valid: " + isValid(sequence1));
        System.out.println(sequence2 + " is valid: " + isValid(sequence2));
        System.out.println(sequence3 + " is valid: " + isValid(sequence3));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
