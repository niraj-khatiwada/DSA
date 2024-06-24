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
        // Circular
        if (this.lastIndex < this.firstIndex) {
            if (this.lastIndex == (this.firstIndex - 1)) {
                throw new IllegalStateException("No space left to add.");
            }
            this.lastIndex++;
            this.array[this.lastIndex] = value;
            return;
        }
        if (this.lastIndex == (this.array.length - 1)) {
            this.lastIndex = 0;
            this.array[this.lastIndex] = value;
        } else {
            this.lastIndex++;
            this.array[this.lastIndex] = value;
        }
    }

    public int remove() {
        if (this.lastIndex == -1) {
            throw new IllegalStateException("No items to remove.");
        }
        var value = this.array[this.firstIndex];
        // Circular
        if (this.lastIndex < this.firstIndex) {
            if (this.firstIndex == (this.array.length - 1)) {
                this.firstIndex = 0;
                return value;
            }
            this.firstIndex++;
            return value;
        }
        if (this.firstIndex == this.lastIndex) {
            this.array[this.firstIndex] = 0;
            this.lastIndex = -1;
            this.firstIndex = -1;
            return value;
        }
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
        if (this.lastIndex == -1) {
            System.out.println("[]");
            return;
        }
        var isCircular = this.lastIndex < this.firstIndex;
        int[] array = new int[isCircular ? (this.array.length - 1 - this.lastIndex) + this.firstIndex
                : (this.lastIndex - this.firstIndex + 1)];
        var startingIndex = this.firstIndex;
        for (var i = 0; i < array.length; i++) {
            if (this.lastIndex < this.firstIndex) {
                array[i] = this.array[startingIndex];
                startingIndex++;
                if (startingIndex >= this.array.length) {
                    startingIndex = 0;
                }
            } else {
                array[i] = this.array[this.firstIndex + i];
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

// Sample to test with
// var queue = new ArrayQueue(5);
// queue.add(1);
// queue.add(2);
// queue.add(3);
// queue.remove();
// queue.remove();
// queue.add(4);
// queue.add(5);
// queue.remove();
// queue.remove();
// queue.add(6);
// queue.add(7);
// queue.add(8);
// queue.add(9);
// queue.print();
// queue.remove();
// queue.remove();
// queue.remove();
// queue.remove();
// queue.remove();
// queue.print();
// queue.add(9);
// queue.print();