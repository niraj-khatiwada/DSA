package Queue;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int currentIndex = -1;

    // O(1)
    public void add(int value) {
        var node = new Node(value);
        this.currentIndex++;
        if (this.tail == null) {
            this.head = this.tail = node;
            return;
        }
        if (this.head == this.tail) {
            this.head.next = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
        this.tail.next = null;
    }

    // O(2)
    public int remove() {
        if (this.tail == null) {
            throw new IllegalArgumentException("No items to remove.");
        }
        this.currentIndex--;
        var value = this.head.value;
        if (this.head == this.tail) {
            this.head = this.tail = null;
            return value;
        }
        this.head = this.head.next;
        return value;
    }

    // O(1)
    public int peek() {
        if (this.tail == null) {
            throw new IllegalArgumentException("No items to peek.");
        }
        return this.head.value;
    }

    // O(1)
    public int size() {
        return this.currentIndex + 1;
    }

    // O(1)
    public boolean isEmpty() {
        return this.currentIndex == -1;
    }
}

// var queue = new LinkedListQueue();
// System.out.println(queue.isEmpty());
// queue.add(10);
// System.out.println(queue.peek());
// queue.add(20);
// queue.add(30);
// System.out.println(queue.remove());
// queue.add(10);
// System.out.println(queue);
// System.out.println(queue.size());