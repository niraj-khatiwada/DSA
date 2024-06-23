package Stack;

import java.util.Arrays;

public class StackUsingArray {
    private int[] array;
    private int currentIndex = -1;

    public StackUsingArray(int size) {
        this.array = new int[size]; // Problem with this approach is that you cannot exceed more than this size.
    }

    public void push(int value) {
        this.currentIndex++;
        this.array[this.currentIndex] = value;
    }

    public int pop() {
        if (this.currentIndex < 0) {
            throw new IllegalArgumentException("No item to pop.");
        }
        var lastItem = this.array[this.currentIndex];
        this.array[this.currentIndex] = 0;
        this.currentIndex--;
        return lastItem;
    }

    public int peek() {
        if (this.currentIndex < 0) {
            throw new IllegalArgumentException("No item to peek.");
        }
        return this.array[this.currentIndex];
    }

    public boolean isEmpty() {
        return this.currentIndex == 0;
    }

    public void print() {
        var array = new int[this.currentIndex + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.array[i];
        }
        System.out.println(Arrays.toString(array));
    }

}
