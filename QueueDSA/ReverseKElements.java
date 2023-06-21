package QueueDSA;

import java.util.Queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseKElements {
    Queue<Integer> queue = new ArrayDeque<>();

    public ReverseKElements() {
        this.queue.add(10);
        this.queue.add(20);
        this.queue.add(30);
        this.queue.add(40);
        this.queue.add(50);
    }

    public void reverse(int k) {
        if (k < 0 || k > this.queue.size()) {
            throw new IllegalStateException();
        }
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < k; i++) {
            stack.push(this.queue.remove());

        }

        while (!stack.isEmpty()) {
            this.queue.add(stack.pop());
        }

        for (int i = 0; i < (this.queue.size() - k); i++) {
            this.queue.add(this.queue.remove());
        }

    }
}
