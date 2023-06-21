package StackDSA;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    // O(1);
    public void push(int item) {
        this.queue1.add(item);
        this.top = item;
    }

    // O(n)
    public int pop() {
        int queue1Size = this.queue1.size();
        for (int i = 0; i < queue1Size - 1; i++) {
            this.queue2.add(this.queue1.remove());
        }
        while (!this.queue2.isEmpty()) {
            this.queue1.add(this.queue2.remove());
        }
        int topItem = this.queue1.remove();
        top = topItem;
        return topItem;
    }

    // public int pop() {
    // int queue1Size = this.queue1.size();
    // for (int i = 0; i < queue1Size - 1; i++) {
    // this.top = this.queue1.remove();
    // this.queue2.add(this.top);
    // }

    // int topItem = this.queue1.remove();

    // Queue<Integer> tempStack = this.queue1;
    // this.queue1 = this.queue2;
    // this.queue2 = tempStack;

    // return topItem;
    // }

    // O(n)
    public int peek() {
        return this.top;
    }

    // O(1)
    public int size() {
        return this.queue1.size();
    }

    // O(1)
    public boolean isEmpty() {
        return this.queue1.size() == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.queue1.toArray());
    }
}
