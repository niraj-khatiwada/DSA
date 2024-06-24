package Queues;

import java.util.Arrays;

// We need to use two pointers first and last.
public class ArrayQueue {
    private int[] array;
    private int firstIndex;
    private int lastIndex;

    public ArrayQueue(int size) {
        this.array = new int[size];
        this.firstIndex = this.lastIndex = -1;
    }

    public void add(int value) {
        if (this.lastIndex == -1) {
            this.firstIndex++;
            this.lastIndex++;
            this.array[this.firstIndex] = value;
            return;
        }
        this.lastIndex++;
        this.array[this.lastIndex] = value;
    }

    public int remove() {
        if (this.lastIndex == -1) {
            throw new IllegalStateException("No items to remove.");
        }
        if (this.firstIndex == this.lastIndex) {
            var value = this.array[this.firstIndex];
            this.array[this.firstIndex] = 0;
            this.lastIndex = -1;
            this.firstIndex = -1;
            return value;
        }
        var value = this.array[this.firstIndex];
        this.firstIndex++;
        return value;
    }

    public int peek() {
        if (this.lastIndex == -1) {
            throw new IllegalArgumentException("No item to peek.");
        }
        return this.array[this.firstIndex];

    }

    public boolean isEmpty() {
        return this.lastIndex == -1;
    }

    public void print() {
        int[] array = new int[this.lastIndex == -1 ? 0 : (this.lastIndex - this.firstIndex + 1)];
        if (array.length > 0) {
            var index = 0;
            for (var i = this.firstIndex; i <= this.lastIndex; i++) {
                array[index] = this.array[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
