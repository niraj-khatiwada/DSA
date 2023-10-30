package Queues;

public class ArrayQueue {
    private int headIndex = -1;
    private int tailIndex = -1;
    private final int[] array;

    public ArrayQueue(int size) {
        this.array = new int[size];
    }

    // O(1)
    public void enqueue(int value) {
        if (this.isFull()) {
            throw new Error("Cannot fit more");
        }
        if (this.headIndex == this.tailIndex && this.headIndex == -1) {
            this.headIndex++;
        }
        this.tailIndex++;
        if (this.tailIndex + 1 > this.array.length) {
            this.tailIndex = this.array.length - this.tailIndex;
        }
        this.array[this.tailIndex] = value;
    }

    // O(1)
    public int dequeue() {
        if (this.tailIndex == -1) {
            throw new Error("No item dequeue");
        }
        if (this.headIndex > (this.array.length - 1)) {
            throw new Error("No item to dequeue.");
        }
        int popped = this.array[this.headIndex];
        if (this.headIndex == this.tailIndex) {
            this.headIndex = this.tailIndex = -1;
        } else {
            this.headIndex++;
        }
        if (this.headIndex > (this.array.length - 1)) {
            this.headIndex = 0;
        }
        return popped;
    }

    // O(1)
    public int peek() {
        if (this.headIndex > this.tailIndex) {
            throw new Error("No item to peek.");
        }
        return this.array[this.headIndex];
    }

    // O(1)
    public boolean isEmpty() {
        return this.headIndex == this.tailIndex && this.headIndex == -1;
    }

    // O(1)
    public boolean isFull() {
        if (this.tailIndex >= this.headIndex) {
            return (this.tailIndex - this.headIndex + 1) == this.array.length;
        } else {
            return (this.array.length - this.headIndex + this.tailIndex + 1) == this.array.length;
        }
    }

    public int[] toArray() {
        int length = 0;
        if (this.headIndex != -1 && this.tailIndex != -1) {
            if (this.headIndex > this.tailIndex) {
                length = (this.array.length - this.headIndex) + this.tailIndex + 1;
            } else {
                length = this.tailIndex - this.headIndex + 1;
            }
        }
        int[] newArray = new int[length];

        int currentIndex = this.headIndex;
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.array[currentIndex > (this.array.length - 1) ? (currentIndex - this.array.length) : currentIndex];
            currentIndex++;
        }

        return newArray;
    }


}