package Heaps;

public class PriorityQueue {
    private Heap heap;

    private int currentIndex = -1;
    private int size;

    public PriorityQueue(int size) {
        this.size = size;
        this.heap = new Heap(size);
    }

    // O(logn)
    public void add(int value) {
        if ((this.currentIndex + 1) >= this.size) {
            throw new IllegalStateException("Queue is full.");
        }
        this.heap.insert(value);
        this.currentIndex++;
    }

    // O(logn)
    public int remove() {
        if (this.currentIndex == -1) {
            throw new IllegalStateException("No item to remove.");
        }
        this.currentIndex--;
        return this.heap.remove();
    }

    public int size() {
        return this.currentIndex + 1;
    }

    public boolean isEmpty() {
        return this.currentIndex == -1;
    }
}

// var queue = new PriorityQueue(5);

// queue.add(3);
// queue.add(2);
// queue.add(4);
// queue.add(1);
// queue.add(5);

// System.out.println(queue.remove());
// System.out.println(queue.remove());
// System.out.println(queue.remove());
// System.out.println(queue.remove());
// System.out.println(queue.remove());