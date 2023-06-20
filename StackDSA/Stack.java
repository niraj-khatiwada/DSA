package StackDSA;

public class Stack {
    private int[] stack = new int[5];
    private int index = -1;

    public void push(int item) {
        if (this.index == stack.length - 1) {
            throw new StackOverflowError();
        }
        this.index++;
        stack[this.index] = item;
    }

    public int pop() {
        if (this.index == -1) {
            throw new IllegalArgumentException();
        }
        int lastItem = this.stack[this.index];
        this.stack[this.index] = 0;
        this.index--;
        return lastItem;

    }

    public int peek() {
        if (this.index == -1) {
            throw new IllegalArgumentException();
        }
        return stack[this.index];
    }

    public boolean isEmpty() {
        return this.index == -1;
    }

    public int[] toArray() {
        int[] array = new int[this.index + 1];
        for (var i = 0; i < this.index + 1; i++) {
            array[i] = stack[i];
        }
        return array;
    }
}
