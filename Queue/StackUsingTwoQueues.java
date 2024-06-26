package Queue;

import java.util.Queue;
import java.util.ArrayDeque;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public StackUsingTwoQueues() {
        this.queue1 = new ArrayDeque<Integer>();
        this.queue2 = new ArrayDeque<Integer>();
    }

    // O(1)
    public void push(int value) {
        top = value;
        this.queue1.add(value);
    }

    // O(n)
    public int pop() {
        if (this.queue1.size() == 0) {
            throw new IllegalArgumentException("No item to pop.");
        }

        while (this.queue1.size() != 1) {
            this.queue2.add(this.queue1.remove());
        }
        var itemToRemove = this.queue1.remove();

        while (!this.queue2.isEmpty()) {
            this.queue1.add(this.queue2.remove());
        }
        return itemToRemove;
    }

    // O(1)
    public int peek() {
        if (this.queue1.size() == 0) {
            throw new IllegalArgumentException("No item to peek.");
        }
        return this.top;
    }

    // O(1)
    public int size() {
        return this.queue1.size();
    }

    // O(1)
    public boolean isEmpty() {
        return this.queue1.isEmpty();
    }

    public void print() {
        System.out.println(this.queue1);
    }

}
