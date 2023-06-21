package StackDSA;

import java.util.Arrays;

public class Main {
    public static void main(String[] __) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        // stack.pop();
        System.out.println(stack.peek());

    }
}