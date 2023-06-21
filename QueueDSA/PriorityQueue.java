package QueueDSA;

public class PriorityQueue {
    public int[] queue;
    private int index = -1;

    public PriorityQueue(int length) {
        this.queue = new int[length];

    }

    public void enqueue(int item) {
        if (this.index == this.queue.length - 1) {
            throw new StackOverflowError();
        }
        if (this.index == -1) {
            this.index++;
            this.queue[this.index] = item;
            return;
        }
        int i;
        for (i = this.index; i >= 0; i--) {
            int current = this.queue[i];
            if (item <= current) {
                this.queue[i + 1] = current;
            } else {
                break;
            }
        }
        this.queue[i + 1] = item;
        this.index++;

    }

    public int dequeue() {
        if (this.index == -1) {
            throw new IllegalStateException();
        }
        int last = this.queue[this.index];
        this.queue[this.index] = 0;
        this.index--;
        return last;
    }

    public int[] toArray() {
        int[] array = new int[this.index + 1];
        for (int i = 0; i < this.index + 1; i++) {
            array[i] = this.queue[i];
        }
        return array;
    }

}
