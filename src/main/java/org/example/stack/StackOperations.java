package org.example.stack;

public class StackOperations {

    public static boolean areBalancedParanthesis(String s) {
        Stack<Character> stack = new StackWithLinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            Character expectedParathesis = null;
            Character actualParathesis;

            if (c == ')') {
                expectedParathesis = '(';
            } else if (c == ']') {
                expectedParathesis = '[';
            } else if (c == '}') {
                expectedParathesis = '{';
            }
            actualParathesis = stack.pop();

            if (actualParathesis == null || !actualParathesis.equals(expectedParathesis)) {
                return false;
            }
        }

        return stack.peek() == null;
    }

}
