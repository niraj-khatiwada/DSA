package StackDSA;

import java.util.Arrays;

public class Main {
    public static void main(String[] __) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(1);
        stack.push(0);
        // stack.push(2);
        // stack.push(0);

        stack.pop();
        stack.pop();

        System.out.println(stack.min());

    }
}