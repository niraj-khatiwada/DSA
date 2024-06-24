package Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int value) {
        this.stack1.push(value);
        if (!stack2.isEmpty()) {
            if (value < this.stack2.peek()) {
                this.stack2.push(value);
            }
        } else {
            this.stack2.push(value);
        }
    }

    public int pop() {
        var value = this.stack1.pop();
        if (!this.stack2.isEmpty()) {
            if (this.stack2.peek() == value) {
                this.stack2.pop();
            }
        }
        return value;
    }

    public int min() {
        return this.stack2.peek();
    }
}
