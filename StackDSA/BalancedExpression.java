package StackDSA;

import java.util.Stack;
import java.lang.Character;
import java.lang.IllegalArgumentException;

public class BalancedExpression {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack();
        Stack<Character> trackerStack = new Stack();

        final String openBrackets = "({[<";
        final String closedBrackets = ")}]>";

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (openBrackets.contains(ch.toString())) {
                stack.push(ch);
                trackerStack.push(BalancedExpression.getCorrespondingCloseBracket(ch));
            } else if (closedBrackets.contains(ch.toString())) {
                if (!stack.empty()) {
                    if (ch == trackerStack.peek()) {
                        stack.pop();
                        trackerStack.pop();
                    }

                }
            }
        }
        return stack.empty();
    }

    public static Character getCorrespondingCloseBracket(Character openBracket) {
        Character ch = '_';
        switch (openBracket) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '<':
                return '>';
            case '[':
                return ']';
        }
        if (ch == '_') {
            throw new IllegalArgumentException();
        }
        return ch;
    }
}
