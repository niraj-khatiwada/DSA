package Queues;

import java.util.Stack;

public class StackQueue {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> queueStack = new Stack<>();

    int count = -1;

    public void enqueue(int value) {
        if (this.mainStack.isEmpty()) {
            this.queueStack.push(value);
        }
        this.count++;
        this.mainStack.push(value);
    }

    public int dequeue() {
        if (this.queueStack.isEmpty()) {
            throw new Error("Nothing item to dequeue.");
        }
        int popped = queueStack.pop();
        if (queueStack.isEmpty()) {
            int iteration = this.count;
            for (int i = 0; i < iteration; i++) {
                queueStack.push(mainStack.pop());
                this.count--;
            }
        }
        return popped;
    }

    public int peek() {
        return this.queueStack.peek();
    }

    public boolean isEmpty() {
        return this.queueStack.size() == 0;
    }

    public int[] toArray() {
        int[] array = new int[this.queueStack.size() + this.count];
        for (int i = 0; i < this.queueStack.size(); i++) {
            array[i] = this.queueStack.get(i);
        }
        int index = this.mainStack.size() - this.count;
        for (int i = 0; i < this.count; i++) {
            array[i + this.queueStack.size()] = this.mainStack.get(index);
            index++;
        }
        return array;
    }
}