package StackDSA;

public class Stack {
    private int[] stack = new int[5];
    private int index = -1;

    public void push(int item) {
        if (this.index == stack.length - 1) {
            throw new StackOverflowError();
        }
        if (this.index == -1) {
            this.index = 0;
        } else {
            this.index++;
        }
        stack[this.index] = item;
    }

    public int pop() {
        if (this.index == -1) {
            throw new IllegalArgumentException();
        }
        int lastItem = stack[this.index];
        var list = new int[index + 1];
        for (int i = 0; i < index; i++) {
            list[i] = stack[i];
        }
        stack = list;
        this.index--;
        return lastItem;

    }

    public int peek() {
        if (this.index == -1) {
            throw new IllegalArgumentException();
        }
        return stack[this.index];
    }

    public int[] toArray() {
        int[] array = new int[this.index + 1];
        for (var i = 0; i < array.length; i++) {
            array[i] = stack[i];
        }
        return array;
    }
}
