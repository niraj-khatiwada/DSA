package StackDSA;

import java.util.Arrays;

public class Main {
    public static void main(String[] __) {
        Stack stack = new Stack();

        stack.push(100);
        System.out.println(Arrays.toString(stack.toArray()));
        stack.push(200);
        stack.push(300);
        System.out.println(stack.peek());
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
