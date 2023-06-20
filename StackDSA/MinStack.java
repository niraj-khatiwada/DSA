package StackDSA;

public class MinStack {
    private int[] stack = new int[5];
    private int[] minStack = new int[5];
    private int index = -1;
    private int minIndex = -1;

    public void push(int item) {
        if (this.index == stack.length - 1) {
            throw new StackOverflowError();
        }
        if (this.index == -1) {
            this.minIndex++;
            minStack[this.minIndex] = item;
        } else {
            int lastMinItem = minStack[this.minIndex];
            if (item < lastMinItem) {
                this.minIndex++;
                minStack[this.minIndex] = item;
            }
        }
        this.index++;
        stack[this.index] = item;
    }

    public int pop() {
        if (this.index == -1) {
            throw new IllegalArgumentException();
        }
        if (this.stack[this.index] == this.minStack[this.minIndex]) {
            this.minStack[this.minIndex] = 0;
            this.minIndex--;
        }
        int lastItem = this.stack[this.index];
        this.stack[this.index] = 0;
        this.index--;

        return lastItem;
    }

    public int min() {
        if (this.minIndex == -1) {
            throw new IllegalArgumentException();
        }
        return this.minStack[this.minIndex];
    }

}
