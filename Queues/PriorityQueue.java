package Queues;

public class PriorityQueue {

    int[] array;
    int index = -1;

    public PriorityQueue(int size) {
        this.array = new int[size];
    }

    public void enqueue(int value) {
        if (this.index == -1) {
            this.index++;
            this.array[this.index] = value;
            return;
        }
        for (int i = this.index; i >= 0; i--) {
            if (value < this.array[i]) {
                this.array[i + 1] = this.array[i];
                this.array[i] = value;
            } else {
                this.array[i + 1] = value;
                break;
            }
        }
        this.index++;
    }

    // We assume that highest number has high priority
    public int dequeue() {
        if (this.index == -1) {
            throw new Error("No item to dequeue.");
        }
        this.index--;
        return this.array[this.index + 1];
    }

    public int[] toArray() {
        int[] newArray = new int[this.index + 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }
}