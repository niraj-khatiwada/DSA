package Stack;

import java.util.Stack;

class Reverse {
    public static void main(String[] args) {
        // Stack<Integer> stacks = new Stack<>();
        // stacks.push(1);
        // stacks.push(2);
        // System.out.println(stacks);
        // System.out.println(stacks.peek());
        // System.out.println(stacks.isEmpty());
        // stacks.pop();
        // System.out.println(stacks.size());

        String name = "Niraj";
        var reversed = new StringBuffer();
        var stack = new Stack<Character>();
        for (int i = 0; i < name.length(); i++) {
            stack.push(name.charAt(i));
        }
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        System.out.println(reversed);

    }
}
