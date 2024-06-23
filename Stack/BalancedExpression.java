package Stack;

import java.util.Stack;

public class BalancedExpression {
    public boolean isBalancedExpression(String str) {
        String openingBrackets = "{[(<";
        String closingBrackets = "}])>";

        var stack = new Stack<Character>();

        boolean isBalanced = true;
        for (int i = 0; i < str.length(); i++) {
            var character = str.charAt(i);
            var value = String.format("%s", str.charAt(i));
            if (closingBrackets.contains(value)) {
                if (stack.isEmpty() || (openingBrackets.indexOf(stack.pop()) != closingBrackets.indexOf(value))) {
                    isBalanced = false;
                    break;
                }
            }
            if (openingBrackets.contains(value)) {
                stack.push(character);
            }
        }
        if (!stack.isEmpty()) {
            isBalanced = false;
        }
        return isBalanced;
    }
}
