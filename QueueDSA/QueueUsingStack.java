package QueueDSA;

import java.util.Arrays;
import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // O(1)
    public void enqueue(int item) {
        this.stack1.push(item);
    }

    // O(n)
    public int dequeue() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            throw new IllegalStateException();
        }
        this.migrateToStack2IfEmpty();
        return this.stack2.pop();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public int peek() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            throw new IllegalStateException();
        }
        this.migrateToStack2IfEmpty();
        return this.stack2.peek();

    }

    @Override
    public String toString() {
        int[] array = new int[this.stack1.size() + this.stack2.size()];
        Object[] stack1Array = this.stack1.toArray();
        Object[] stack2Array = this.stack2.toArray();

        for (int i = 0; i <= this.stack2.size() - 1; i++) {
            array[i] = (int) stack2Array[this.stack2.size() - 1 - i];
        }
        int temp = 0;
        for (int i = this.stack2.size(); i < (this.stack2.size() + this.stack1.size()); i++) {
            array[i] = (int) stack1Array[temp];
            temp++;
        }
        return Arrays.toString(array);
    }

    private void migrateToStack2IfEmpty() {
        if (this.stack2.isEmpty()) {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
    }
}
