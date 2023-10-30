import java.util.Stack;

public class Utils {
    // O(n)
    public static boolean isBalancedExpression(String string) {
        Stack<Character> stringStack = new Stack<>();
        Stack<Character> symbolStack = new Stack<>();

        String openingBrackets = "<({[";
        String closingBrackets = ">)}]";

        boolean isBalanced = false;

        for (int i = 0; i < string.length(); i++) {
            stringStack.push(string.charAt(i));
        }

        while (!stringStack.isEmpty()) {
            Character lastItem = stringStack.peek();
            if (closingBrackets.contains(lastItem.toString())) {
                symbolStack.push(lastItem);
            }
            if (openingBrackets.contains(lastItem.toString())) {
                if (symbolStack.size() == 0) {
                    break;
                }
                if (openingBrackets.indexOf(lastItem) != closingBrackets.indexOf(symbolStack.peek())) {
                    break;
                } else {
                    symbolStack.pop();
                }
            }
            stringStack.pop();
        }

        if (stringStack.size() == 0) {
            isBalanced = true;
        }

        return isBalanced;
    }

    // O(n)
    public static String reverseAString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
