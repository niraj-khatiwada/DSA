package QueueDSA;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int headIndex = -1;
    private int tailIndex = -1;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int item) {
        if (this.tailIndex - this.headIndex >= this.queue.length - 1) {
            throw new StackOverflowError();
        }
        if (this.headIndex == -1) {
            this.headIndex++;
        }
        this.tailIndex++;
        int circularIndex = this.tailIndex % this.queue.length;
        this.queue[circularIndex] = item;
    }

    public int dequeue() {
        if (this.tailIndex == -1 || this.headIndex == -1) {
            throw new IllegalArgumentException();
        }
        int item = this.queue[this.headIndex];
        this.queue[this.headIndex] = 0;
        if (this.headIndex == this.tailIndex) {
            this.headIndex = this.tailIndex = -1;
        }
        this.headIndex++;
        return item;
    }

    public int peek() {
        return queue[this.headIndex];
    }

    public boolean isEmpty() {
        return this.headIndex == -1 || this.tailIndex == -1;

    }

    public boolean isFull() {
        return this.tailIndex - this.headIndex == (this.queue.length - 1);
    }

    @Override
    public String toString() {
        if (this.headIndex == -1 || this.tailIndex == -1) {
            return "";
        }
        int size = this.tailIndex - this.headIndex + 1;
        int[] array = new int[size];
        int tempIndex = this.headIndex;
        for (int i = 0; i < size; i++) {
            array[i] = this.queue[tempIndex % this.queue.length];
            tempIndex++;
        }
        return Arrays.toString(array);
    }

}
