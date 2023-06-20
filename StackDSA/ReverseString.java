package StackDSA;

import java.util.Stack;

public class ReverseString {
    public String reverse(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        return reversed;

        /*
         * No idea why a stack is even required to reverse a string above. We can
         * reverse directly from the first for-loop as well.
         */

        // StringBuffer reversed = new StringBuffer();
        // for (int i = str.length() - 1; i >= 0; i--) {
        // reversed.append(str.charAt(i));
        // }
        // return reversed.toString();

    }
}
