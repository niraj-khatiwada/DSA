package Queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void add(int value) {
        this.stack1.push(value);
    }

    public int remove() {
        if (this.stack1.isEmpty()) {
            throw new IllegalStateException("No item to remove.");
        }
        while (!this.stack1.isEmpty()) {
            this.stack2.push(this.stack1.pop());
        }
        var value = this.stack2.pop();
        while (!this.stack2.isEmpty()) {
            this.stack1.push(this.stack2.pop());
        }
        return value;
    }

    public void print() {
        System.out.println(this.stack1);
    }
}

// var queueUsingStack = new StackQueue();
// queueUsingStack.add(1);
// queueUsingStack.add(2);
// queueUsingStack.add(3);
// queueUsingStack.remove();
// queueUsingStack.remove();
// queueUsingStack.print();